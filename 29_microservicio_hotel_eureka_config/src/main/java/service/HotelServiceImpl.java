package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {


	HotelesDao hotelesDao;
	
	
	public HotelServiceImpl(@Autowired HotelesDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}


	public List<Hotel> hotelesDisponibles() {
	
		List<Hotel> hoteles = hotelesDao.findAll();
		
		// Consideramos que un hotel está disponible si su valor para esa campo es 1.
		return hoteles.stream().filter(h -> h.getDisponible()==1).collect(Collectors.toList());

	}
	
	public List<Hotel> hotelPorNombre(String nombre) {
		
		List<Hotel> hoteles = hotelesDao.findByNombre(nombre);
		
		// Puede que no existan hoteles que correspondan con el nombre indicado.
		
		if(hoteles.isEmpty()) {
			return null;
		}
	
		return hoteles.stream().filter(h -> h.getDisponible()==1).collect(Collectors.toList());
	}

}
