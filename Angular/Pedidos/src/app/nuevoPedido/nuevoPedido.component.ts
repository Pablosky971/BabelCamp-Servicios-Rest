import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pedido } from '../model/Pedido';
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
  pd:Pedido;
  constructor(private service: PedidosService, private route:Router) {
    service.productos().subscribe(data => this.listaProductos = data)
   }

   
  pedido() {
    
    this.pd.unidades = this.unidades;
    this.pd.codigoProducto = this.producto.codigoProducto;
    this.service
      .pedido(this.pd)
      .subscribe((data) => console.log(data));
    
  }
  
  volver() {
    this.route.navigate(['']);
  }

  ngOnInit() {
  }

}
