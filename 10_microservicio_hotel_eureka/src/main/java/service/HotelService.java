package service;

import java.util.List;

import model.Hotel;

public interface HotelService {

	List<Hotel> hotelesDisponibles();
	List<Hotel> hotelPorNombre(String nombre);
}
