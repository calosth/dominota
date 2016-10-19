package application.model;

import javafx.beans.property.IntegerProperty;

public class RondaEquipo extends Ronda {

	private Equipo equipo;

	public RondaEquipo(IntegerProperty puntaje, Equipo equipo) {

		super(puntaje);
		this.equipo = equipo;

	}

}
