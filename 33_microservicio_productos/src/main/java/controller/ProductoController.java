package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductoService;

@RestController
@CrossOrigin("*")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping(value="Productos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos() {
		return productoService.productos();	
	}
	
	@PutMapping(value="ActualizarProducto/{unidadesCompradas}/{codigoProducto}", produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean actualizarProductoStock(@PathVariable("unidadesCompradas") int unidadesCompradas, @PathVariable("codigoProducto") int codigoProducto) {
		return productoService.actualizarProductoStock(unidadesCompradas, codigoProducto);
	}
	
	@GetMapping(value="PrecioProducto/{codigoProducto}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String precioProducto(@PathVariable("codigoProducto") int codigoProducto) {
		return String.valueOf(productoService.precioProducto(codigoProducto));	
	}
	
	

}
