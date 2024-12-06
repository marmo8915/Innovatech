import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class GlobalServiceService {
  private userId: string | null = null; 
  constructor() {}

  setUserId(id: string) {
    this.userId = id;
  }

  getUserId(): string | null {
    return this.userId;
  }
}
