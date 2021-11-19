import {Injectable} from "@angular/core";
import Swal from "sweetalert2";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "./auth.service";
import {NgxSpinnerService} from "ngx-spinner";
import {Lista} from "../common/models/lista";
import {ReponseObject} from "../common/models/reponseObject";
import {environment} from "../../environments/environment";
import {AdministradorService} from "./administrador.service";
import {catchError} from "rxjs/operators";
import {throwError} from "rxjs";
import {Usuario} from "../common/models/usuario";

@Injectable({
  providedIn: 'root'
})
export class ListService{

  urlServcice = 'lists';

  constructor(
    private http: HttpClient,
    private ruter: Router,
    private adminService: AdministradorService,
    private authService: AuthService,
    private spinner: NgxSpinnerService
  ) { }

  crearLista(lista: Lista): any{
    return this.http.post<ReponseObject<Lista>>(
      `${environment.urlBase}${this.urlServcice}` , lista, {
        headers: this.adminService.agregarAutorizationHeader()
      }).pipe(
      catchError(e => {
        Swal.fire('Error al cargar', 'error');
        return throwError(e);
      })
    );
  }

  listAll(): any {
    // const params = pageQuery;
    this.spinner.show();
    return this.http.get<ReponseObject<Lista>>(`${environment.urlBase}${this.urlServcice}` )
      .pipe(
        catchError(e => {
          console.log(e.message);
          Swal.fire('Error al cargar', e.message, 'error');
          return throwError(e);
        })
      );
  }


  getList(listName: string): any {
    this.spinner.show();
    return this.http.get<ReponseObject<Lista>>(`${environment.urlBase}${this.urlServcice}/${listName}` )
      .pipe(
        catchError(e => {
          console.log(e.message);
          Swal.fire('Error al cargar', e.message, 'error');
          return throwError(e);
        })
      );
  }

  deleteList(listName: string){
    return this.http.delete<ReponseObject<any>>(
      `${environment.urlBase}${this.urlServcice}/${listName}`
      ).pipe(
      catchError(e => {
        Swal.fire('Error al cargar', 'error');
        return throwError(e);
      })
    );
  }

}
