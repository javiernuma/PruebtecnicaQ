import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {AuthService} from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdministradorService {
  private httpHeaaders = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(
    private http: HttpClient,
    private ruter: Router,
    private authService: AuthService,
    ) { }
  public agregarAutorizationHeader(): HttpHeaders{
    const token = this.authService.token;
    if (token != null){
      return this.httpHeaaders.append('Authorization', 'Bearer ' + token);
    }
    return this.httpHeaaders;
  }



}
