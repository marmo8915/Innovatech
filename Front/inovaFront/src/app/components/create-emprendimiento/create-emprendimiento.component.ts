import { Component } from '@angular/core';
import { GlobalServiceService } from './../../global-service.service';
import Swal from 'sweetalert2';
import { Router, RouterModule } from '@angular/router';
import {
  EmprendimientoService,
  emprendimiento,
} from '../../emprendimiento.service';
import { ReactiveFormsModule } from '@angular/forms';
import { ciudad, CiudadSerciveService } from '../../ciudad-sercive.service';

@Component({
  selector: 'app-create-emprendimiento',
  templateUrl: './create-emprendimiento.component.html',
  styleUrl: './create-emprendimiento.component.css',
})
export class CreateEmprendimientoComponent {
  emprend: emprendimiento = {
    id: 0,
    nit: 0,
    matricula: 0,
    fecha_creacion: new Date(),
    id_ciudad: { id: 0 },
    razon_social: '',
    id_usuario: {
      id: 0,
    },
    nombre: '',
  };

  ciu: ciudad[] = [];
  userId: string | null = '';

  constructor(
    private ciudadService: CiudadSerciveService,
    private emprendimientoService: EmprendimientoService,
    private globalService: GlobalServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.userId = this.globalService.getUserId(); // Obtener el id desde el servicio

    this.ciudadService.getCiudades().subscribe((data) => {
      this.ciu = data;
    });
  }

  onSubmit(): void {
    if (this.userId) {
      this.emprend.id_usuario = {
        id: parseInt(this.userId),
      };
      this.emprend.id_ciudad = {
        id: this.emprend.id_ciudad,
      };
      this.emprendimientoService.createEmprendimiento(this.emprend).subscribe({
        next: (result) => {
          this.router.navigate(['/listEmprendimiento']);

          Swal.fire({
            title: 'Creado',
            text: 'Emprendimiento creado con exito',
            icon: 'info',
          });
        },
        error: (e) => {
          Swal.fire({
            title: 'Error',
            text: '',
            icon: 'info',
          });
        },
      });
    }
  }
}
