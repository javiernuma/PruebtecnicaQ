import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, finalize, tap} from 'rxjs/operators';
import {AuthService} from './auth.service';
import {NgxSpinnerService} from 'ngx-spinner';
import {Router} from "@angular/router";

/**
 * JWT Interceptor intercepts http requests from the application to add a JWT auth token to the Authorization header
 */
@Injectable()
export class JwtErrorInterceptor implements HttpInterceptor {
  constructor(
    private authService: AuthService,
    private spinner: NgxSpinnerService,
    private router: Router,
  ) {

  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add auth header with jwt if user is logged in and request is to the api url
    return next.handle(request).pipe(
      catchError( err => {
        if (err.status === 401){
          if (this.authService.estaAutenticado()){
            this.authService.logout();
          }
          this.router.navigate(['/login']);
        }

        if (err.status === 403){
          this.router.navigate(['/administrador/graduados']);
        }
        this.spinner.hide();
        return throwError(err);
      })
    );
  }
}
