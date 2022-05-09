package service;

import java.util.List;

import model.Vuelo;

public interface VueloService {

	Vuelo vueloPorId(int idVuelo);
	List<Vuelo> vuelos(int plazas);
	void actualizarVuelo(int plazas, int idVuelo);
	
}
