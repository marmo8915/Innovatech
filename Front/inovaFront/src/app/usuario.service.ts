import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface usuario {
  id: number;
  id_rol: number;
  apellido: string;
  email: string;
  nombre: string;
  password: string;
  telefono: string;
}

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/Usuario';
  constructor(private http: HttpClient) {}

  obtenerUsuarioPorCredenciales(email: string, pass: string): Observable<any> {
    const url = `${this.apiUrl}/getInfoUsuario/${email}/${pass}`;
    return this.http.get<any>(url);
  }
}
