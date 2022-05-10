package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import service.VueloService;

@RestController
@CrossOrigin("*")
public class VueloController {
	
	@Autowired
	VueloService vueloService;
	
	@GetMapping(value="Vuelos/{plazas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelos(@PathVariable("plazas") int plazas) {
		return vueloService.vuelos(plazas);	
	}
	
	@PutMapping(value="ActualizarVuelo/{plazas}/{idVuelo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Vuelo actualizarVuelo(@PathVariable("plazas") int plazas, @PathVariable("idVuelo") int idVuelo) {
		vueloService.actualizarVuelo(plazas, idVuelo);
		return vueloService.vueloPorId(idVuelo);
	}

}
