package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno, Integer> {
	
//	Servicio Crud Alumnos:
//
//		- Alta de alumnos a partir de JSON recibido en el cuerpo
//		- Recuperación de todos los alumnos
//		- Busqueda de alumno por id
//		- Eliminación de alumno por id
//		- Actualización de alumno. Cambiar el curso del alumno cuyo id se recibe
//		- recuperación de la lista de curso

	// Opción 1: se le da una lista de cursos ya filtrada.
//	@Query("select distinct(a.curso) from Alumno a")
//	List<String> findCursos();
	
	// Opción 2: no se hace el método anterior y la capa de servicio a partir de la lista de cursos.
	
}
