import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Pedido } from './model/Pedido';
import { Producto } from './model/Producto';
@Injectable({
  providedIn: 'root'
})
export class PedidosService {

  urlProductos="http://localhost:8000/Productos";
  urlPedidos="http://localhost:7000/Pedidos";
  urlPedido="http://localhost:7000/Pedido";

  constructor(private http: HttpClient) { }

pedidos() {
    return this.http.get<Pedido[]>(this.urlPedidos);
}

pedido() {
  return this.http.post<Pedido>(this.urlPedido,null);
}

productos() {
  return this.http.get<Producto[]>(this.urlProductos);
}

}