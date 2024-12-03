import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ciudad {
  id: number;
  departamento: string;
  nombre: string;
  pais: string;
}

@Injectable({
  providedIn: 'root',
})
export class CiudadSerciveService {
  private apiUrl = 'http://localhost:8080/Ciudad';

  constructor(private http: HttpClient) {}

  getCiudades(): Observable<ciudad[]> {
    debugger;
    return this.http.get<ciudad[]>(this.apiUrl);
  }
}
