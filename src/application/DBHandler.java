package application;
import application.model.*;

import java.time.LocalDate;

import com.db4o.*;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.query.Query;

public class DBHandler {
	private static ObjectContainer DB;

	public DBHandler() {
		DB = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Dominota.db4o");
		System.out.println("Base de datos abierta");
	}

	public void addJugador(String iniciales){
		 Jugador jugador = new Jugador();
		 jugador.setIniciales(iniciales);
	       try{
	            DB.store(jugador);
	            System.out.println("Se ha almacenado correctamente el usuario");
	        }catch(DatabaseClosedException | DatabaseReadOnlyException e){System.out.println("Se ha producido un error en la insercion");}
	 }

	 public void addEquipo(String nombreeq,Jugador jugador1, Jugador jugador2){
		 Equipo equipo = new Equipo();
//		 Jugador jugador1 = new Jugador();
//		 Jugador jugador2 = new Jugador();
//		 jugador1.setIniciales("AVVR");
//		 jugador2.setIniciales("EFVR");
//		 equipo.setJugador1(jugador1);
//		 equipo.setJugador2(jugador2);
		 try {
			 DB.store(equipo);
			 System.out.println("Se ha almacenado correctamente el equipo");
		 }catch(DatabaseClosedException | DatabaseReadOnlyException e){System.out.println("Se ha producido un error en la insercion");}
	 }
	 public void addPartidaIndividual(Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4,
			 String nombrePartida, boolean finalizada,LocalDate date, int puntajeMaximo){

		 PartidaIndividual partidaind = new PartidaIndividual(jugador1,jugador2,jugador3,jugador4,nombrePartida,finalizada,date, puntajeMaximo);

		 try {
			 DB.store(partidaind);
			 System.out.println("Se ha almacenado correctamente la partida individual");
		 }catch(DatabaseClosedException | DatabaseReadOnlyException e){System.out.println("Se ha producido un error en la insercion");}
	 }
	 public void addPartidaEquipos(Equipo equipo1, Equipo equipo2,String nombrePartida,
			 boolean finalizada,LocalDate date, int puntajeMaximo){
		 PartidaEquipos partidaeqp = new PartidaEquipos(equipo1,equipo2,nombrePartida,finalizada, date, puntajeMaximo);
		 try {
			 DB.store(partidaeqp);
			 System.out.println("Se ha almacenado correctamente la partida equipos");
		 }catch(DatabaseClosedException | DatabaseReadOnlyException e){System.out.println("Se ha producido un error en la insercion");}
	 }

	 public static ObjectSet consultarJugador(String iniciales){
		 Jugador jugador = new Jugador(iniciales, null);
		 ObjectSet q = DB.queryByExample(jugador);
		 return q;
	 }

	 public static ObjectSet consultarEquipo(String nombre_equipo){
		 Equipo equipo = new Equipo(nombre_equipo, null,null);
		 ObjectSet q = DB.queryByExample(equipo);
		 return q;
	 }

	 public void consultarPartidaFinalizada(){
		 Query query = DB.query();
	     query.constrain(PartidaIndividual.class);//declara las restricciones
	     ObjectSet<PartidaIndividual> resultado = query.execute();
	     verPartidasInd(resultado);
	 }
	 public void consultar_PartidasPorEquipo(String nombre_equipo){
		 Query query = DB.query();
	     query.constrain(Equipo.class);
	     ObjectSet<Equipo> resultado = query.execute();

	 }
	 public static void verPartidasInd(ObjectSet<PartidaIndividual> resultado) {
        System.out.println("Recuperados " + resultado.size() + " Objetos");
        while (resultado.hasNext()) {
        	if(resultado.next().getFinalizada()==false){
        		System.out.println(resultado.next().getnombrePartida());
        	}
        }
	 }
	 public void consultarPartidaFinalizadaEqp(){
	     Query query = DB.query();
	       query.constrain(PartidaEquipos.class);//declara las restricciones
	       ObjectSet<PartidaEquipos> resultado = query.execute();
	       verPartidasfinEqp(resultado);
	   }

	   public static void verPartidasfinEqp(ObjectSet<PartidaEquipos> resultado) {
	        System.out.println("Recuperados " + resultado.size() + " Objetos");
	        while (resultado.hasNext()) {
	          if(resultado.next().getFinalizada()==false){
	            System.out.println(resultado.next().getnombrePartida());
	          }
	        }
	   }
	 public void imprimirJugador(){
		 Query query = DB.query();
        query.constrain(Jugador.class);//declara las restricciones
        ObjectSet<Jugador> resultado = query.execute();
        imprimirResultadoConsulta(resultado);
	 }

	 public void imprimirEquipo(){
		 Query query = DB.query();
        query.constrain(Equipo.class);//declara las restricciones
        ObjectSet<Equipo> resultado = query.execute();
        imprimirResultadoConsultaEquipo(resultado);
	 }

	 public static void imprimirResultadoConsultaEquipo(ObjectSet<Equipo> resultado) {
        System.out.println("Recuperados " + resultado.size() + " Objetos");
        while (resultado.hasNext()) {
            System.out.println(resultado.next().getNombre());
           // System.out.println(resultado.next().getJugador2());
        }
     }

	 public static void imprimirResultadoConsulta(ObjectSet<Jugador> resultado) {
        System.out.println("Recuperados " + resultado.size() + " Objetos");
        while (resultado.hasNext()) {
            System.out.println(resultado.next().getIniciales());
        }
     }


}
