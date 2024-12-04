import { GlobalServiceService } from './../../global-service.service';
import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { Router, RouterModule } from '@angular/router';

import {
  EmprendimientoService,
  emprendimiento,
  lisEmprendimientos,
} from '../../emprendimiento.service';
import { ciudad, CiudadSerciveService } from '../../ciudad-sercive.service';

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
  selectedEmprendimiento: any = null; // Objeto seleccionado para editar
  ciu: ciudad[] = [];

  constructor(
    private Empr: EmprendimientoService,
    private globalService: GlobalServiceService,
    private ciudadService: CiudadSerciveService,
    private router: Router
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

  eliminarEmprendimiento(id: number): void {
    Swal.fire({
      title: '¿Estás seguro de que deseas eliminar este emprendimiento?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.Empr.deleteEmprendimiento(id).subscribe({
          next: () => {
            Swal.fire({
              title: 'Creado',
              text: 'Emprendimiento eliminado exitosamente',
              icon: 'success',
            });
            this.objectos = this.objectos.filter((item) => item.id !== id);
          },
          error: (err) => {
            Swal.fire({
              title: 'Error',
              text: 'rror al eliminar el emprendimiento',
              icon: 'error',
            });
          },
        });
      }
    });
  }

  editarEmprendimiento(emprendimiento: any): void {
    // Copia el emprendimiento seleccionado
    this.selectedEmprendimiento = { ...emprendimiento };

    let dataC: ciudad[] = [];
    this.ciudadService.getCiudades().subscribe((data) => {
      Swal.fire({
        title: 'Editar Emprendimiento',
        html: `
          <input id="nit" class="swal2-input" placeholder="NIT" value="${
            this.selectedEmprendimiento.nit
          }">
          <input id="matricula" class="swal2-input" placeholder="Matrícula" value="${
            this.selectedEmprendimiento.matricula
          }">
          <input id="nombre" class="swal2-input" placeholder="Nombre" value="${
            this.selectedEmprendimiento.nombre
          }">
          <input id="razon_social" class="swal2-input" placeholder="Razón Social" value="${
            this.selectedEmprendimiento.razonSocial
          }">
          <select id="ciudad" class="swal2-input">
            ${data
              .map((ciudad) => {
                return `
              <option value="${ciudad.id}">${ciudad.nombre}</option>`;
              })
              .join('')}
          </select>
          <input id="fecha_creacion" class="swal2-input" type="datetime-local" placeholder="Fecha Creación" value="${new Date(
            this.selectedEmprendimiento.fechaCreacion
          )
            .toISOString()
            .slice(0, 16)}">
        `,
        focusConfirm: false,
        showCancelButton: true,
        confirmButtonText: 'Guardar',
        cancelButtonText: 'Cancelar',
        preConfirm: () => {
          return {
            nit: (document.getElementById('nit') as HTMLInputElement).value,
            matricula: (
              document.getElementById('matricula') as HTMLInputElement
            ).value,
            nombre: (document.getElementById('nombre') as HTMLInputElement)
              .value,
            razonSocial: (
              document.getElementById('razon_social') as HTMLInputElement
            ).value,
            id_ciudad: (document.getElementById('ciudad') as HTMLInputElement)
              .value,
            fechaCreacion: (
              document.getElementById('fecha_creacion') as HTMLInputElement
            ).value,
          };
        },
      }).then((result) => {
        if (result.isConfirmed) {
          const updatedData = result.value;
          updatedData.id_ciudad = {
            id: updatedData.id_ciudad,
          };
          // Actualiza el emprendimiento con los datos modificados
          this.Empr.updateEmprendimiento(
            this.selectedEmprendimiento.id,
            updatedData
          ).subscribe({
            next: () => {
              // Actualiza la lista localmente
              const index = this.objectos.findIndex(
                (obj) => obj.id === this.selectedEmprendimiento.id
              );
              if (index > -1) {
                this.objectos[index] = {
                  ...this.selectedEmprendimiento,
                  ...updatedData,
                };
              }

              this.router.navigate(['/listEmprendimiento']);

              Swal.fire({
                title: 'Actualizado',
                text: 'El emprendimiento se actualizó correctamente.',
                icon: 'success',
              });
            },
            error: (err) => {
              console.error('Error al actualizar', err);
              Swal.fire({
                title: 'Error',
                text: 'Hubo un problema al actualizar el emprendimiento.',
                icon: 'error',
              });
            },
          });
        }
      });
    });
  }
}
