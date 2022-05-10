package service;

import java.util.List;

import model.Estudiante;

public interface EstudianteService {
	void altaEstudiante(Estudiante estudiante);

	List<Estudiante> estudiantesNotaMinima(double puntuacion);
	
}
