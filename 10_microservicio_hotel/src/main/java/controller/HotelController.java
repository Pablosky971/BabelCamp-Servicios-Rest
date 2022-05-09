package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping(value="Hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles() {
		return hotelService.hotelesDisponibles();	
	}
	
	@GetMapping(value="Hoteles/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hotelPorNombre(@PathVariable("nombre") String nombre) {
		return hotelService.hotelPorNombre(nombre);
	}

}
