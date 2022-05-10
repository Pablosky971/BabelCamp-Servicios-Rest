package service;

import java.util.List;

import model.Vuelo;

public interface VueloService {

	Vuelo vueloPorId(int idVuelo);
	List<Vuelo> vuelos(int plazas);
	boolean actualizarVuelo(int plazas, int idVuelo);
	
}
