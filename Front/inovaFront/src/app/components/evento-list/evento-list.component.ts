import { GlobalServiceService } from './../../global-service.service';
import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { Router, RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-evento-list',
  templateUrl: './evento-list.component.html',
  styleUrl: './evento-list.component.css',
})
export class EventoListComponent {
  userId: string | null = '';

  constructor(
    private globalService: GlobalServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {}
}
