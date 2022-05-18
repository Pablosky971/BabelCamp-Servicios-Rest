export class Pedido {
    idPedido:number;
    codigoProducto:number;
    unidades:number;
    total:number;
    fechaPedido:Date;


    public toString() : string {
        return JSON.stringify(this)
    }
}