package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Estudiante;
import service.EstudianteService;

@RestController
public class EstudianteController {

	@Autowired
	EstudianteService service;
	
	@PostMapping(value="Estudiante", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaEstudiante(@RequestBody Estudiante estudiante) {
		service.altaEstudiante(estudiante);
	}
	@GetMapping(value="Estudiantes/{puntuacion}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Estudiante> estudiantesPuntuacion(@PathVariable("puntuacion") double puntuacion){
		return service.estudiantesNotaMinima(puntuacion);
	}
	
}
