import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class GlobalServiceService {
  private userId: string | null = null; // Variable global

  constructor() {}

  // Método para establecer el id global
  setUserId(id: string) {
    this.userId = id;
  }

  // Método para obtener el id global
  getUserId(): string | null {
    return this.userId;
  }
}
