import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../model/Producto';
import { PedidosService } from '../pedidos.service';

@Component({
  selector: 'app-nuevoPedido',
  templateUrl: './nuevoPedido.component.html',
  styleUrls: ['./nuevoPedido.component.css']
})
export class NuevoPedidoComponent implements OnInit {

  listaProductos:Producto[];
  producto:Producto;
  unidades:number;
  constructor(private service: PedidosService, private route:Router) {
    service.productos().subscribe(data => this.listaProductos = data)
   }

   
  pedido() {
    this.service
      .pedido()
      .subscribe((data) => console.log(data));
    
  }
  
  volver() {
    this.route.navigate(['']);
  }

  ngOnInit() {
  }

}
