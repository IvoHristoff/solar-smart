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
        ArrayList<Item> itemList = loadPartsList();

    }

    public static void main(String[] args) {
        launch();
    }

    public static ArrayList<Item> loadPartsList() {

        //Initial parts list hardcoded for prototype

        ArrayList<Item> itemList = new ArrayList<>();

        SolarPanel solarPanel1 = new SolarPanel("SunBurn Factor 50",200, 175.4, 109.6, 405);
        Inverter inverter1 = new Inverter("SB2000", 400, 2000);
        Inverter inverter2 = new Inverter("SB5000", 600, 5000);
        Inverter inverter3 = new Inverter("SB6000", 800, 6000);
        Inverter inverter4 = new Inverter("SB8000", 1000, 8000);
        Inverter inverter5 = new Inverter("SB12000", 1500, 12000);

        itemList.add(solarPanel1);
        itemList.add(inverter1);
        itemList.add(inverter2);
        itemList.add(inverter3);
        itemList.add(inverter4);
        itemList.add(inverter5);

        return itemList;

    }
}