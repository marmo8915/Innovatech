import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface emprendimiento {
  id: number;
  nit: number;
  matricula: number;
  fecha_creacion: Date;
  nombre: string;
  id_ciudad: object;
  razon_social: string;
  id_usuario: object;
}

export interface lisEmprendimientos {
  nit: number;
  matricula: number;
  fechaCreacion: Date;
  razonSocial: string;
  ciudad: string;
  usuario: string;
  nombre: String;
}

@Injectable({
  providedIn: 'root',
})
export class EmprendimientoService {
  private apiUrl = 'http://localhost:8080/Emprendimiento';

  constructor(private http: HttpClient) {}

  getEmprendimiento(): Observable<lisEmprendimientos[]> {
    return this.http.get<lisEmprendimientos[]>(this.apiUrl);
  }

  getEmprendimientos(id: number): Observable<lisEmprendimientos[]> {
    const url = `${this.apiUrl}/getEmprendimientoUsuario/${id}`;
    return this.http.get<lisEmprendimientos[]>(url);
  }

  createEmprendimiento(emmp: emprendimiento): Observable<emprendimiento> {
    return this.http.post<emprendimiento>(this.apiUrl, emmp);
  }
}
