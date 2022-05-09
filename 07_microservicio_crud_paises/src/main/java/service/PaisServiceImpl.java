package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	RestTemplate template;
	String urlBase="https://restcountries.com/v2/all";
	public PaisServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}

	Pais[] paises;
	@PostConstruct
	public void init() {
		paises = template.getForObject(urlBase, Pais[].class);
	}
	
	

	@Override
	public List<String> continentes() {
		
		// Recogemos todos los países:
		
		
		return Arrays.stream(paises).map(p -> p.getContinente()).distinct().collect(Collectors.toList());
	}

	@Override
	public List<Pais> paisesContinente(String continente) {
		
		return Arrays.stream(paises).filter(p -> p.getContinente().equals(continente)).collect(Collectors.toList());
	}

	@Override
	public long habitantesContinente(String continente) {
		
		return Arrays.stream(paises).filter(p -> p.getContinente().equals(continente)).mapToLong(p -> p.getPoblacion()).sum();
	}

}
