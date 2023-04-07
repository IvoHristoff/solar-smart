package nl.saxion.re.solarsmart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-menu.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);

        stage.setTitle("Main menu");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }


}