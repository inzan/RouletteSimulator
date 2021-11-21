package edu.miracosta.cs210.roulette;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    //@Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("roulette.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 700, 480);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        scene.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
//        stage.show();
//    }

    public void start1(Stage stage) throws FileNotFoundException {
        //Creating an image
        //FileInputStream input = new FileInputStream("/");
        Image image = new Image(HelloApplication.class.getResourceAsStream("roulette-table.jpg"));

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        //Creating a Group object
        Group root = new Group(imageView);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 500);

        //Setting title to the Stage
        stage.setTitle("Loading an image");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public void addWheel(Scene scene) {
        scene.getStylesheets().add("test.css");
        Rectangle rect = new Rectangle(100,100);
        rect.setLayoutX(50);
        rect.setLayoutY(50);
        rect.getStyleClass().add("my-rect");
        Parent p = scene.getRoot();
        ((Group)scene.getRoot()).getChildren().add(rect);
    }

    private StackPane root = new StackPane();
    private Stage stage;

    @Override
    public void init() {
        Button button = new Button("LOGIN");//new Button("OPEN");
        VBox vBox = new VBox();
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                new Label("Your Username"),
                new TextField(),
                new Label("Your Password"),
                new PasswordField(),
                button);
        root.getChildren().addAll(vBox);

        button.setOnAction(actionEvent-> {
//            if(stage!=null){
//                stage.requestFocus();
//                return;
//            }

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("roulette.fxml"));

            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 700, 520);
                stage.setTitle("Hello!");
                stage.setScene(scene);
                scene.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
                stage.show();
//                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//                stage.setTitle("Hello!");
//
//                stage.setScene(scene);
////            stage = new Stage();
////            StackPane stackPane = new StackPane();
////            stage.setScene(new Scene(stackPane, 200,200));
//                stage.show();
            } catch (IOException ioe) {

            }
        });
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Scene scene = new Scene(root,700,480);
        //scene.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Login Example JavaFX");
        primaryStage.setAlwaysOnTop(true);
    }

    public static void main(String[] args) {
        launch();
    }
}