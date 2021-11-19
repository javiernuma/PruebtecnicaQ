import {Component, OnDestroy, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import {FormBuilder, Validators} from '@angular/forms';
import {Subscription} from "rxjs";
import {Usuario} from "../../common/models/usuario";
import {AuthService} from "../../servicios/auth.service";
import {ContantesMensajes} from "../../common/constanstes/contantesMensajes";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {
  usuario: Usuario;
  mySlogin: Subscription;
  constructor(
    private authService: AuthService,
    private router: Router,
    private spinner: NgxSpinnerService,
    private fb: FormBuilder,
  ) {
    this.usuario = new Usuario();
  }

  error = {
    message: ContantesMensajes.MGS_ERROR
  };

  public loginFrom = this.fb.group({
      login: ['', Validators.required],
      contrasena: ['', Validators.required],
    },
  );

  ngOnInit(): void {
    this.usuario = new Usuario();
  }


  login(): void {
    this.usuario.login = this.loginFrom.get('login').value;
    this.usuario.contrasena = this.loginFrom.get('contrasena').value;
      if (this.usuario.login === undefined || this.usuario.contrasena === undefined){
      Swal.fire('Error en el fromulario', 'login y contraseña vacias', 'error');
      return;
    }

      this.mySlogin  = this.authService.login(this.usuario).subscribe(response => {

      localStorage.setItem('id', response['id_usuario']);
      this.authService.guardarUsuario(response.access_token);
      this.authService.guardarToken(response.access_token);
      const usuario = this.authService.usuario;
      this.router.navigate(['/graduado/publicaciones']);
     //  Swal.fire('Inicio de sesion', `HoHla ${usuario.persona.nombre}, Has iniciado sesion con exito`, 'success');
    }, error => {
      if (error.status === 400){
        Swal.fire('Datos inavlidos', '', 'error');
      }
    });
  }

  ngOnDestroy(): void {
    if (this.mySlogin != null){
      this.mySlogin.unsubscribe();
    }
  }


}
