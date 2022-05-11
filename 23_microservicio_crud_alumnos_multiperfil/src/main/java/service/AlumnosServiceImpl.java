package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import model.Alumno;

@Service
public class AlumnosServiceImpl implements AlumnoService {

	public AlumnosServiceImpl(@Autowired AlumnosDao alumnosDao) {
		super();
		this.alumnosDao = alumnosDao;
	}

	AlumnosDao alumnosDao;
	
	public void altaAlumno(Alumno alumno) {
		alumnosDao.save(alumno);

	}


	public Alumno buscarAlumno(int id) {
		
		return alumnosDao.findById(id).orElse(null);
	}

	
	public boolean eliminarAlumno(int idAlumno) {
		
		Optional<Alumno> a = alumnosDao.findById(idAlumno);
		
		if(a.isPresent()) {
			alumnosDao.delete(a.get());
			return true;
		}
		return false;
	}

	
	public boolean actualizarAlumno(int idAlumno, String curso) {
		Optional<Alumno> a = alumnosDao.findById(idAlumno);
		
		if(a.isPresent()) {
			Alumno alumno = a.get();
			alumno.setCurso(curso);
			alumnosDao.save(alumno);
			return true;
		}
		return false;

	}

	
	public List<Alumno> todosAlumnos() {
		
		return alumnosDao.findAll();
	}


	public List<String> cursos() {
		
		return alumnosDao.findAll().stream().map(a -> a.getCurso()) // Stream con los nombres de los cursos.
				.distinct() // Stream sin duplicados.
				.collect(Collectors.toList());
	}

}
