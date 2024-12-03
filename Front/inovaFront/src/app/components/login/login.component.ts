import { Component } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { UsuarioService } from '../../usuario.service';
import { GlobalServiceService } from '../../global-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginData = {
    email: '',
    password: '',
  };
  usuarioInfo: any;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private globalService: GlobalServiceService
  ) {}

  onSubmit(): void {
    console.log('Datos de inicio de sesión:', this.loginData);

    this.usuarioService
      .obtenerUsuarioPorCredenciales(
        this.loginData.email,
        this.loginData.password
      )
      .subscribe(
        (data) => {
          console.log('Información del usuario:', data);
          this.usuarioInfo = data;
          this.globalService.setUserId(data[0][0]); // Guardamos el id en el servicio
          this.router.navigate(['/listEmprendimiento']);
        },
        (error) => {
          console.error('Error al obtener información del usuario:', error);
        }
      );
    // Aquí puedes añadir lógica para autenticar al usuario
  }
}
