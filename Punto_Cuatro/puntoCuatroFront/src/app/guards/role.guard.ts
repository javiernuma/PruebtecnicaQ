import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from '../servicios/auth.service';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const role = route.data['role'] as string;
    if (!this.authService.estaAutenticado()){
      this.router.navigate(['/login']);
      return false;
    }
    if (this.authService.hasRol(role)){
      return true;
    }
    Swal.fire('Acceso Denegado', `No tienes acceso a este recuerso`, 'warning' );
    return false;
  }

}
