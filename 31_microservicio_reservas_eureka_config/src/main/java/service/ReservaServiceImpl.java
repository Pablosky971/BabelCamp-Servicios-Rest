package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	
	RestTemplate template;
	String urlBase="http://servicio-vuelos/";

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
		
		ResponseEntity<String> response = template.exchange(urlBase + "ActualizarVuelo/" + plazasVuelo + "/" + reserva.getVuelo(), HttpMethod.PUT,null // new HttpEntity(dato_cuerpo)
				,String.class);
		
		// Solo guardamos la reserva si se ha actualizado el número de plazas de los vuelos
		String cuerpo = response.getBody();
		if(cuerpo.equals("true")) {
			reservasDao.save(reserva);
		}
//		template.put(urlBase + "ActualizarVuelo/" + plazasVuelo + "/" + reserva.getVuelo(), Vuelo.class);
		reservasDao.save(reserva);

	}



	



	


	

	
}
