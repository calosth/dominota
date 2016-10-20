package application;

import java.io.IOException;

import application.model.*;
import application.view.HomeController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private DBHandler DB;

	 /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Jugador> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {

    	DB = new DBHandler();



    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Jugador> getPersonData() {
        return personData;
    }


	@Override
	public void start(Stage primaryStage) {

		DB.addJugador("New Player");
		DB.imprimirJugador();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Dominota");

		initRootLayout();

		showHome();
	}

	public void initRootLayout(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout  = (BorderPane) loader.load();

			Scene scene =new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public void showHome(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Home.fxml"));
			AnchorPane home = (AnchorPane) loader.load();

			rootLayout.setCenter(home);

			 /*HomeController controller = loader.getController();
		     controller.setMainApp(this);*/
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
