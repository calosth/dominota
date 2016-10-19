package application.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class PartidaIndividual extends Partida {
    private  Jugador jugador1;
    private  Jugador jugador2;
    private  Jugador jugador3;
    private  Jugador jugador4;
    private  ArrayList<RondaIndividual> rondas;

    public PartidaIndividual(Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4,
    String nombrePartida, boolean finalizada, LocalDate date, int puntajeMaximo){
    	super(nombrePartida,finalizada,date,puntajeMaximo);
    	this.jugador1 = jugador1;
    	this.jugador2 = jugador2;
    	this.jugador3 = jugador3;
    	this.jugador4 = jugador4;
    	this.rondas = new ArrayList<RondaIndividual>();
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Jugador getJugador3() {
        return jugador3;
    }

    public Jugador getJugador4() {
        return jugador4;
    }

    public void addRonda(RondaIndividual ronda) {
    	this.rondas.add(ronda);
    }
}