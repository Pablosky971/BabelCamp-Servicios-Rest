package dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import model.Vuelo;

public interface VuelosDao extends JpaRepository<Vuelo, Integer> {
	
	@Modifying
	@Query("update Vuelo v set v.plazas= v.plazas-?1 where v.idvuelo=?2")
	void actualizarVuelo(int plazas, int idVuelo);

}
