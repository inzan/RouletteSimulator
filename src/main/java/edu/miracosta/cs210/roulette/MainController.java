package edu.miracosta.cs210.roulette;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    static final String ROULETTE_FX = "roulette.fxml";
    static final String HELLO_FX = "hello-view.fxml";

    public Stage primaryStage;

    public MainController(Stage stage) {
        this.primaryStage = stage;
    }

    public void pushRouletteWheelScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(ROULETTE_FX));
        //fxmlLoader.setController(rouletteController);
        try {
            Scene scene = new Scene(fxmlLoader.load(), 700, 520);
            RouletteController rouletteController = (RouletteController) fxmlLoader.getController();
            rouletteController.setMainController(this);
            primaryStage.setTitle("Play Roulette!");
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
            primaryStage.show();
        } catch (IOException ioe) {
            System.err.println("Unable to open JavaFX File : " + ROULETTE_FX);
        }
    }

    public void pushAboutScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(HELLO_FX));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 700, 520);
            HelloController helloController = (HelloController) fxmlLoader.getController();
            helloController.setMainController(this);
            primaryStage.setTitle("About");
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
            primaryStage.show();
        } catch (IOException ioe) {
            System.err.println("Unable to open JavaFX File : " + HELLO_FX);
        }
    }

}
