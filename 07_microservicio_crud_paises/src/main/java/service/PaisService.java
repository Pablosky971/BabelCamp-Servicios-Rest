package service;

import java.util.List;

import model.Pais;

public interface PaisService {


	List<String> continentes();
	List<Pais> paisesContinente(String continente);
	long habitantesContinente(String continente);
	
}
