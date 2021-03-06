package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisService;

@RestController
public class PaisController {

	@Autowired
	PaisService service;
	
	@GetMapping(value="Continentes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes () {
		return service.continentes();
	}
	@GetMapping(value="Paises/{continente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesContinente(@PathVariable("continente") String continente) {
		return service.paisesContinente(continente);
	}
	
	@GetMapping(value="ContinentePoblacion/{continente}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String poblacionContinente(@PathVariable("continente") String continente) {
		return String.valueOf(service.habitantesContinente(continente));
	}
}
