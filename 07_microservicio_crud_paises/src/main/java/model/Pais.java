package model;



import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pais {
	@JsonAlias("name")
	private String nombre;
	private String capital;
	@JsonAlias("region")
	private String continente;
	@JsonAlias("population")
	private long poblacion;
	@JsonAlias("flag")
	private String bandera;
}
