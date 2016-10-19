package application.model;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Partida {
	private final StringProperty nombrePartida;
    private final BooleanProperty finalizada;
    private final ObjectProperty<LocalDate> fecha;
    private int puntajeMaximo;

    public Partida() {
    	this.nombrePartida = new SimpleStringProperty(null);
        this.finalizada = new SimpleBooleanProperty(false);
        this.fecha = new SimpleObjectProperty<LocalDate>(LocalDate.now());
        this.puntajeMaximo = 200;
    }

    public Partida(String nombrePartida, boolean finalizada, LocalDate date, int puntajeMaximo) {
    	this.nombrePartida = new SimpleStringProperty(nombrePartida);
        this.finalizada = new SimpleBooleanProperty(finalizada);
        this.fecha = new SimpleObjectProperty<LocalDate>(LocalDate.of(
        		date.getDayOfMonth(),
        		date.getMonthValue(),
        		date.getYear())
        );
        this.puntajeMaximo = puntajeMaximo;

    }

    public String getnombrePartida() {
        return nombrePartida.get();
    }

    public void setnombrePartida(String nombrePartida) {
        this.nombrePartida.set(nombrePartida);
    }

    public boolean getFinalizada() {
        return finalizada.get();
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada.set(finalizada);
    }

    public BooleanProperty finalizadaProperty() {
        return finalizada;
    }

    public LocalDate getFecha() {
        return fecha.get();
    }

    public ObjectProperty<LocalDate> fechaProperty() {
        return fecha;
    }
}