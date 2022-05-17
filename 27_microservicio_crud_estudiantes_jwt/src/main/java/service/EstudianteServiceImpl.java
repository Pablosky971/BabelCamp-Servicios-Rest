package service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dtos.UserPwdDto;
import model.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	RestTemplate template;
	String urlBase="http://localhost:8000/crud";
	@Value("${user}")
	String user;

	@Value("${pwd}")
	String pwd;

	String token;
	public EstudianteServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}
	
	private void getToken() {
		var dto = new UserPwdDto(user,pwd);
		token = template.postForObject(urlBase+"/login",dto,String.class);
		
		
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization", "Bearer "+token);
		return headers;
	}

	@Override
	public void altaEstudiante(Estudiante estudiante) {
		
		if(token==null||token.equals("")) {
			getToken();
		}
		
		// Construimos el encabezado autorization con el token
	
		template.exchange(urlBase+"/Alumno",HttpMethod.POST,new HttpEntity<>(estudiante,getHeaders()), Void.class); // Void siempre para indicar que no hay respuesta.
		// Consumimos el servicio Rest "altaAlumno".
		template.postForLocation(urlBase+"/Alumno", estudiante);
	}

	@Override
	public List<Estudiante> estudiantesNotaMinima(double puntuacion) {

		if(token==null||token.equals("")) {
			getToken();
		}
		
		// Construimos el encabezado autorization con el token
		
		Estudiante[] estudiantes=template.exchange(urlBase+"/Alumnos", 
				HttpMethod.GET, 
				new HttpEntity<>(getHeaders()),
				Estudiante[].class).getBody();
	

		// Utilizamos streams para filtrar y transformar en lista.
		return Arrays.stream(estudiantes) // stream
				.filter(s->s.getPuntuacion()>=puntuacion) // filtramos por puntuación
				.collect(Collectors.toList()); // List<Estudiante>

	}





}
