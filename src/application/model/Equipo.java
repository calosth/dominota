package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase Modelo para Jugador.
 *
 */
public class Equipo{

	//public?
    private final StringProperty nombre;
    private Jugador jugador1;
    private Jugador jugador2;

    /**
     * Default constructor.
     */

    public Equipo() {
    	this(null, null, null);
    }

    public Equipo(String nombre, Jugador jugador1, Jugador jugador2){
    	super();
    	this.nombre = new SimpleStringProperty(nombre);
    	this.jugador1 = jugador1;
    	this.jugador2 = jugador2;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

}