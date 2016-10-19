package application.model;

import javafx.beans.property.IntegerProperty;

public class RondaIndividual extends Ronda {

	private Jugador jugador;

	public RondaIndividual(Jugador jugador, IntegerProperty puntaje) {

		super(puntaje);

		this.jugador = jugador;

	}
}
