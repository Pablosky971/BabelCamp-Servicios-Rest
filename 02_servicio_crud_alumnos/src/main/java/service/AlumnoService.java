package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {
	void altaAlumno(Alumno alumno);
	Alumno buscarAlumno(int id);
	boolean eliminarAlumno(int idAlumno);
	boolean actualizarAlumno(int idAlumno, String curso);
	List<Alumno> todosAlumnos();
	List<String> cursos();
}
