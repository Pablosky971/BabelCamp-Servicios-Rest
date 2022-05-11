package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Pais;
import service.PaisService;

@RestController
public class PaisController {

	@Autowired
	PaisService service;
	
	@ApiOperation(value="Devuelve los continentes.")
	@GetMapping(value="Continentes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes () {
		return service.continentes();
	}
	
	@ApiOperation(value="Devuelve países pertenecientes al continente señalado.")
	@GetMapping(value="Paises/{continente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesContinente( @ApiParam(value="Nombre del continente sobre el que se quiere obtener lo países que lo componen.")@PathVariable("continente") String continente) {
		return service.paisesContinente(continente);
	}
	
	@ApiOperation(value="Muestra el número de habitates del continente explicitado.")
	@GetMapping(value="ContinentePoblacion/{continente}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String poblacionContinente( @ApiParam(value="Nombre del continente sobre el que se quiere conocer el número total de población.")@PathVariable("continente") String continente) {
		return String.valueOf(service.habitantesContinente(continente));
	}
}
