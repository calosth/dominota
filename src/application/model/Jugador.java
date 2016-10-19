package application.model;


import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase Modelo para Jugador.
 *
 */
public class Jugador {

    private final StringProperty iniciales;
    private final StringProperty genero;
    private final ObjectProperty<LocalDate> fechaDeNacimiento;

    /**
     * Default constructor.
     */
    public Jugador() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param iniciales
     * @param genero
     */
    public Jugador(String iniciales, String genero) {
        this.iniciales = new SimpleStringProperty(iniciales);
        this.genero = new SimpleStringProperty(genero);

        // TODO remove dummy .
        this.fechaDeNacimiento = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getIniciales() {
        return iniciales.get();
    }

    public void setIniciales(String firstName) {
        this.iniciales.set(firstName);
    }

    public StringProperty inicialesProperty() {
        return iniciales;
    }

    public String getGenero() {
        return genero.get();
    }

    public void setGenero(String genero) {
        this.genero.set(genero);
    }

    public StringProperty generoProperty() {
        return genero;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento.get();
    }

    public void setFechaDeNacimiento(LocalDate birthday) {
        this.fechaDeNacimiento.set(birthday);
    }

    public ObjectProperty<LocalDate> fechaDeNacimientoProperty() {
        return fechaDeNacimiento;
    }
}