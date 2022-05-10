package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	
	RestTemplate template;
	String urlBase="http://localhost:9001/";

	ReservasDao reservasDao;
	
	
	public ReservaServiceImpl(@Autowired ReservasDao reservasDao, @Autowired RestTemplate template) {
		super();
		this.reservasDao = reservasDao;
		this.template = template;
	}


	
	public List<Reserva> reservas() {
		
		return reservasDao.findAll();
	}
	
	public void reservar(Reserva reserva,  int plazasVuelo) {
		
		reservasDao.save(reserva);
		template.put(urlBase + "ActualizarVuelo/" + plazasVuelo + "/" + reserva.getVuelo(), Vuelo.class);
		

	}



	



	


	

	
}
