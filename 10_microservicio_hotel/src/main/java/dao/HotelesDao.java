package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Hotel;

public interface HotelesDao extends JpaRepository<Hotel, Integer> {
	

	List<Hotel> findByNombre(String nombre);

}
