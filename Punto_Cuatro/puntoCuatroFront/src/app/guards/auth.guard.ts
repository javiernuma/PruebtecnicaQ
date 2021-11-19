import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from '../servicios/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private router: Router
    ) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.authService.estaAutenticado()){
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }

  elTokenEstaExpirado(): boolean{
    const token = this.authService.token;
    const payload = this.authService.obtenerDatosToken(token);
    const ahora = new Date().getTime() / 1000;

    return payload.exp < ahora;
  }

}
