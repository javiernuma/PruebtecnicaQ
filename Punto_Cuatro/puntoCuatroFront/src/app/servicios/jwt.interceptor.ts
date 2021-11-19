import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import {finalize, tap} from 'rxjs/operators';
import {AuthService} from './auth.service';
import {NgxSpinnerService} from 'ngx-spinner';

/**
 * JWT Interceptor intercepts http requests from the application to add a JWT auth token to the Authorization header
 */
@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(
    private authService: AuthService,
    private spinner: NgxSpinnerService,
  ) {

  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add auth header with jwt if user is logged in and request is to the api url
    const currentUser = this.authService.usuario;
    let token = this.authService.token;
    if (token != null) {
      const authReq = request.clone({
        headers: request.headers.set('Authorization', 'Bearer ' + token)
      });
      this.spinner.show();
      return next.handle(authReq).pipe(
        finalize( () => {
          this.spinner.hide();
        })
      );
    }
    return next.handle(request)
      .pipe(finalize( () => {
          this.spinner.hide();
      }));
  }
}
