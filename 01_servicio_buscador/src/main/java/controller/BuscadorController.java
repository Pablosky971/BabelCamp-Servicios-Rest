package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Pagina;
import service.BuscadorService;

@RestController
public class BuscadorController {
	
	@Autowired
	BuscadorService service;
	
	@GetMapping(value="Paginas",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> paginas(){
		return service.paginas();
	}
	
//	@GetMapping(value="Buscador",produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<Pagina> buscador(@RequestParam("tematica") String tematica){
//		return service.buscar(tematica);
//	}
	
	
	// Variables dentro de la propia URL.
	@GetMapping(value="Paginas/{tematica}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> buscador(@PathVariable("tematica") String tematica){
		return service.buscar(tematica);
	}
	
	@PostMapping(value="Pagina",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody Pagina pagina) {
		service.alta(pagina);
	}
	
	@DeleteMapping(value="Pagina")
	public void eliminar(@RequestParam("tematica") String tematica) {
		service.eliminar(tematica);
	}
	
	// Se indica produces, porque, adem?s de consumir, tambi?n retorna un resultado en JSON.
	@PutMapping(value="Pagina",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Pagina actualizar(@RequestBody Pagina pagina) {
		return service.actualizar(pagina);
	}
	
	@PutMapping(value="Pagina/{direccion}")
	public void actualizarTematica(@PathVariable("direccion") String direccion, @RequestParam("tematica") String tematica) {
		service.actualizarTematica(direccion,tematica);
	}
	
	
	

}
