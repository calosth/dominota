package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Clase Modelo para Jugador.
 *
 */
public class Ronda {

	private IntegerProperty puntaje;

    /**
     * Default constructor.
     */
    public Ronda() {
        this(null);
    }

    public Ronda(IntegerProperty puntaje) {
    	this.puntaje = puntaje;
		//this.puntaje = new SimpleIntegerProperty(puntaje);
	}

	public IntegerProperty getpuntaje() {
        //return puntaje.get();
		return puntaje;
	}

    public void setPuntaje(IntegerProperty puntaje) {
        //this.puntaje.set(puntaje);
    	this.puntaje = puntaje;
    }

    public IntegerProperty puntajeProperty() {
        return puntaje;
    }
}