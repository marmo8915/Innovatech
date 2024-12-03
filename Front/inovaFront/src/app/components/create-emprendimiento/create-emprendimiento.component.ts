import { Component } from '@angular/core';
import { GlobalServiceService } from './../../global-service.service';
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
    id_ciudad: 0,
    razon_social: '',
    id_usuario: 0,
    nombre: '',
  };

  ciu: ciudad[] = [];
  userId: string | null = '';

  constructor(
    private ciudadService: CiudadSerciveService,
    private emprendimientoService: EmprendimientoService,
    private globalService: GlobalServiceService
  ) {}

  ngOnInit(): void {
    this.userId = this.globalService.getUserId(); // Obtener el id desde el servicio

    this.ciudadService.getCiudades().subscribe((data) => {
      this.ciu = data;
    });
  }

  onSubmit(): void {
    if (this.userId) {
      debugger;
      this.emprend.id_usuario = parseInt(this.userId);
      this.emprendimientoService.createEmprendimiento(this.emprend).subscribe({
        next: (result) => {
          alert('creado');
        },
        error: (e) => {
          alert('error');
        },
      });
    }
  }
}
