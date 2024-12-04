import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface evento {
  id: number;
  titulo: string;
  descripcion: string;
  fecha: Date;
  ubicacion: string;
  id_usuario: object;
}

export interface ListaEventos {
  id: number;
  titulo: string;
  descripcion: string;
  fecha: Date;
  ubicacion: string;
  ciudad: string;
}

@Injectable({
  providedIn: 'root',
})
export class EventoServiceService {
  private apiUrl = 'http://localhost:8080/Emprendimiento';

  constructor(private http: HttpClient) {}
}
