import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Pedido } from './model/Pedido';
import { PedidosService } from './pedidos.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Pedidos';
  pedidos:Pedido[];

  constructor(private service: PedidosService, private route:Router) {
    service.pedidos().subscribe(data => (this.pedidos=data))
  }

  routeNuevoPedido() {
    this.route.navigate(['/nuevoPedido']);
  }
}
