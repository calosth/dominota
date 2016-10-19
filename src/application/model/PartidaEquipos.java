package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase Modelo para Jugador.
 *
 */
public class PartidaEquipos extends Partida {

	//public?
    private  Equipo equipo1;
    private  Equipo equipo2;
    private  ArrayList<RondaEquipo> rondas;

    /**
     * Default constructor.
     */


    public PartidaEquipos(Equipo equipo1, Equipo equipo2, String nombrePartida, boolean finalizada, LocalDate date, int puntajeMaximo){
    	super(nombrePartida,finalizada, date, puntajeMaximo);
    	this.equipo1 = equipo1;
    	this.equipo2 = equipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void addRonda(RondaEquipo ronda) {
    	this.rondas.add(ronda);
    }
}