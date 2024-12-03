import { GlobalServiceService } from './../../global-service.service';
import { Component } from '@angular/core';
import {
  EmprendimientoService,
  emprendimiento,
  lisEmprendimientos,
} from '../../emprendimiento.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-emprendimiento-list',
  templateUrl: './emprendimiento-list.component.html',
  styleUrl: './emprendimiento-list.component.css',
})
export class EmprendimientoListComponent {
  empren: emprendimiento[] = [];
  objectos: lisEmprendimientos[] = [];
  userId: string | null = '';
  usuarioName: String = '';
  constructor(
    private Empr: EmprendimientoService,
    private globalService: GlobalServiceService
  ) {}

  formatFecha(fecha: Date): Date {
    return fecha;
  }

  ngOnInit(): void {
    this.userId = this.globalService.getUserId(); // Obtener el id desde el servicio

    if (this.userId)
      this.Empr.getEmprendimientos(parseInt(this.userId)).subscribe((data) => {
        this.objectos = data;
        this.usuarioName = data[0].usuario;
      });
    console.log(this.empren);
  }
}
