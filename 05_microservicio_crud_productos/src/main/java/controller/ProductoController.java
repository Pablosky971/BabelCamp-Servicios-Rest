package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductoService;

@CrossOrigin("*")
@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping("Buscar")
	public String buscarPorSeccion(@RequestParam("seccion") String seccion, HttpServletRequest request) { 
		
		List<Producto> productos = productoService.buscarSeccion(seccion);
		request.setAttribute("productos", productos);
		
		return "listado";
		
	}
	
	@PostMapping("Alta")
	public String alta(@ModelAttribute Producto p) {
		productoService.alta(p);
		return "alta";
	}
	
	
	
	@PostMapping("Eliminar")
	public String eliminar(@RequestParam("idProducto") int idProducto) {
		productoService.eliminar(idProducto);
		return "eliminar";
	}
 	
	
}
