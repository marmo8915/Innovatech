import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // Importa FormsModule

import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmprendimientoListComponent } from './components/emprendimiento-list/emprendimiento-list.component';
import { CreateEmprendimientoComponent } from './components/create-emprendimiento/create-emprendimiento.component';
import { LoginComponent } from './components/login/login.component';
import { EventoListComponent } from './components/evento-list/evento-list.component';

@NgModule({
  declarations: [
    AppComponent,
    EmprendimientoListComponent,
    CreateEmprendimientoComponent,
    LoginComponent,
    EventoListComponent,
  ],
  imports: [BrowserModule, FormsModule, AppRoutingModule, HttpClientModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
