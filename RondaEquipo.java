package application.model;
import javafx.beans.property.IntegerProperty;
//Clase para manipular puntajes por equipo.
public class RondaEquipo extends Ronda {
	private Equipo equipo;

	public RondaEquipo(IntegerProperty puntaje, Equipo equipo) {
		super(puntaje);
		this.equipo = equipo;
	}
}
