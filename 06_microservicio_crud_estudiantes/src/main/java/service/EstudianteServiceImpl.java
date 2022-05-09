package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import model.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	RestTemplate template;
	String urlBase="http://localhost:8000/crud";
	public EstudianteServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public void altaEstudiante(Estudiante estudiante) {
		
		// Consumimos el servicio Rest "altaAlumno".
		template.postForLocation(urlBase+"/Alumno", estudiante);
	}

	@Override
	public List<Estudiante> estudiantesNotaMinima(double puntuacion) {
		
		// Recogemos todos los estudiantes en un array
		Estudiante[] estudiantes = template.getForObject(urlBase+"/Alumnos", Estudiante[].class);
		
		// Utilizamos streams para filtrar y transformar en lista.
		return Arrays.stream(estudiantes) // stream
				.filter(s->s.getPuntuacion()>=puntuacion) // filtramos por puntuación
				.collect(Collectors.toList()); // List<Estudiante>

	}

	
	


}
