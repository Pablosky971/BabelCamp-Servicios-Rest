package model;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Estudiante {
	
	private String nombre;
	private String curso;
	@JsonProperty(value="nota")
	private double puntuacion;
}
