package service;

import java.util.List;

import model.Producto;

public interface ProductoService {

	List<Producto> productos();
	boolean actualizarProductoStock(int unidadesCompradas, int codigoProducto);
	double precioProducto(int codigoProducto);
}
