import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Pedido } from './model/Pedido';
import { Producto } from './model/Producto';
@Injectable({
  providedIn: 'root'
})
export class PedidosService {

  url="http://localhost:10000";
  

  constructor(private http: HttpClient) { }

pedidos() {
    return this.http.get<Pedido[]>(this.url + "/spedidos/Pedidos");
}

pedido(pd : Pedido) {
  let headers = new HttpHeaders();
  headers = headers.set('Content-Type', 'application/json; charset=utf-8');
  return this.http.post(this.url + "/spedidos/Pedido",pd.toString(),{"headers":headers});
}

productos() {
  return this.http.get<Producto[]>(this.url + "/sproductos/Productos" );
}

}