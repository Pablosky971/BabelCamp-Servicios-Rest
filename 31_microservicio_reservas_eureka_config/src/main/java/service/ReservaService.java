package service;

import java.util.List;

import model.Reserva;

public interface ReservaService {

	List<Reserva> reservas();
	void reservar(Reserva reserva, int plazasVuelo);
}
