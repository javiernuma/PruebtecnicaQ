import { Injectable } from '@angular/core';
import {Observable, throwError} from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Usuario} from '../common/models/usuario';
import {environment} from '../../environments/environment';
import {catchError, finalize} from 'rxjs/operators';
import Swal from 'sweetalert2';
import { NgxSpinnerService } from 'ngx-spinner';
import {ReponseObject} from "../common/models/reponseObject";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _usuario: Usuario | undefined;
  private _token: string | null | undefined;

  constructor(
    private http: HttpClient,
    private spinner: NgxSpinnerService
  ) { }
  public get usuario(): Usuario{
    if (this._usuario != null){
      return this._usuario;
    } else if ( (this._usuario == null || this._usuario === undefined) && sessionStorage.getItem('usuario')  != null){
      this._usuario = JSON.parse(<string>sessionStorage.getItem('usuario')) as Usuario;
      return this._usuario;
    }
    return  new Usuario();
  }
  public get token(): string{
    if (this._token != null){
      return this._token;
    } else if ( (this._token == null || this._token === undefined) && sessionStorage.getItem('token') != null){
      this._token = sessionStorage.getItem('token');
      return <string>this._token;
    }
    return null;
  }

  login(usuario: Usuario): Observable<any>{
    const url = environment.urlBase + 'oauth/token';
    const credenciales = btoa('front' + ':' + '12345');
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      Authorization: 'Basic ' + credenciales});
    const params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', usuario.login);
    params.set('password', usuario.contrasena);
    this.spinner.show();
    return this.http.post<any>(url, params.toString(), {headers: httpHeaders}).pipe(
      catchError(e => {
        this.spinner.show();
        Swal.fire('Error al iniciar sesion', '', 'error');
        return throwError(e);
      })
    );
  }

  guardarUsuario(accessToken: string): void{
    const payload = this.obtenerDatosToken(accessToken);
    this._usuario = new Usuario();
    this._usuario.nombre = payload.nombre_usuario;
    this._usuario.apellido = payload.apellido_usuario;
    this._usuario.login = payload.login_usuario;
    this._usuario.id = payload.id_usuario;
    this._usuario.roles = payload.authorities;
    sessionStorage.setItem('usuario', JSON.stringify(this._usuario));
  }
  guardarToken(accessToken: string): void{
    this._token = accessToken;
    sessionStorage.setItem('token', accessToken);

  }

  obtenerDatosToken(accessToken: string): any{
    if (accessToken != null){
      return JSON.parse(atob(accessToken.split('.')[1]));
    }
    return null;
  }

  estaAutenticado(): boolean{
    const payload = this.obtenerDatosToken(this.token);
    if (payload != null && payload.nombre_usuario.length > 0){
      return true;
    }
    return false;
  }

  hasRol(role: string): boolean {
    if (this.usuario.roles.includes(role)){
      return true;
    }
    return false;

  }

  recurarContrasena(cedula: string): any{
    const params = cedula;
    this.spinner.show();
    return this.http.post<ReponseObject<string>>(`${environment.urlBase}usuario/cambiarclave`, params )
      .pipe(
        catchError(e => {
          console.log(e.message);
          Swal.fire('Error al cargar', e.message, 'error');
          return throwError(e);
        })
      );
  }


  logout(): void{
    this._token = null;
    this._usuario = null;
    sessionStorage.clear();
  }
}
