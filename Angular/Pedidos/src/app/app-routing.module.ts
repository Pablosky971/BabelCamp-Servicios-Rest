import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NuevoPedidoComponent } from './nuevoPedido/nuevoPedido.component';

const routes: Routes = [

  {
    path : 'nuevoPedido',
    component : NuevoPedidoComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
