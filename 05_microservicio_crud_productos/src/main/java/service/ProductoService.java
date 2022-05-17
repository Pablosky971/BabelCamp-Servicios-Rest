package service;

import java.util.List;

import model.Producto;

public interface ProductoService {
	
	List<Producto> buscarSeccion(String seccion);
	void alta(Producto p);
	void eliminar(int idProducto);
	Producto buscarProducto(int idProducto);

}
