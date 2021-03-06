package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Hotel;
import service.HotelService;

@RestController
@CrossOrigin("*")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	String data;
	
	@ApiOperation(value="Devuelve los hoteles disponibles.")
	@GetMapping(value="Hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles() {
		return hotelService.hotelesDisponibles();	
	}
	
	@ApiOperation("Proporciona el hotel designado por el nombre indicado.")
	@GetMapping(value="Hoteles/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hotelPorNombre(@ApiParam(value="Nombre del hotel que se pretende obtener como resultado.") @PathVariable("nombre") String nombre) {
		return hotelService.hotelPorNombre(nombre);
	}

}
