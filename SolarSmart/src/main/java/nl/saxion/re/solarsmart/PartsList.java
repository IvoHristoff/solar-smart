package nl.saxion.re.solarsmart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PartsList implements Initializable {


    @FXML
    public ListView partsListView;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Item> itemList = loadPartsList();

        ObservableList<Item> observableList = FXCollections.observableArrayList(itemList);


        partsListView.setItems(observableList);

        partsListView.setCellFactory(param -> new ListCell<Item>() {
            @Override
            protected void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null)
                {
                    setText(null);
                } else
                {
                    setText(item.toString());
                }
            }
        });

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
