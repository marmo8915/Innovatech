import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmprendimientoListComponent } from './components/emprendimiento-list/emprendimiento-list.component';
import { CreateEmprendimientoComponent } from './components/create-emprendimiento/create-emprendimiento.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'createEmprendimiento', component: CreateEmprendimientoComponent },
  { path: 'listEmprendimiento', component: EmprendimientoListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
