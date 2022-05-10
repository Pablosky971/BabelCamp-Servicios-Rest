package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VueloServiceImpl implements VueloService {


	VuelosDao vuelosDao;
	
	
	public VueloServiceImpl(@Autowired VuelosDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}


	public List<Vuelo> vuelos(int plazas) {
		
		List<Vuelo> vuelos = vuelosDao.findAll();
		
		return vuelos.stream().filter(v -> v.getPlazas() > plazas).collect(Collectors.toList());
	}

	@Transactional
	public void actualizarVuelo(int plazas, int idVuelo) {
	
		Vuelo v = vueloPorId(idVuelo);
		
		if(v.getPlazas() > plazas) {
			vuelosDao.actualizarVuelo(plazas, idVuelo);
		} 
		
	}



	public Vuelo vueloPorId(int idVuelo) {
		
		Optional<Vuelo> v = vuelosDao.findById(idVuelo);
		
		if(v.isPresent()) {
		return v.get();
		}
		return null;
	}

	
}
