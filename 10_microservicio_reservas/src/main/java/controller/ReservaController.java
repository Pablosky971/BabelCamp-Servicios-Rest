package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Reserva;
import service.ReservaService;

@RestController
@CrossOrigin("*")
public class ReservaController {
	
	@Autowired
	ReservaService reservaService;
	
	@GetMapping(value="Reservas", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> reservas() {
		return reservaService.reservas();	
	}
	
	@PostMapping(value="Reserva/{plazas}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void reservar(@RequestBody Reserva reserva, @PathVariable("plazas") int plazas) {
		reservaService.reservar(reserva, plazas);
	}

}
