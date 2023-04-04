package nl.saxion.re.solarsmart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SolarSmartController {

    // --"T"-- stands for TextField //
    @FXML
    public TextField firstNameT;
    @FXML
    public TextField lastNameT;
    @FXML
    public TextField roofWT;
    @FXML
    public TextField roofHT;
    @FXML
    public TextField powerConsT;


    public String firstName;

    public String lastName;

    public double roofW;

    public double roofH;

    public int powerCons;

    public void onConfirm(ActionEvent actionEvent){
        firstName = firstNameT.getText();
        System.out.println("Mr/Ms " + firstName);

        lastName = lastNameT.getText();
        System.out.println(lastName);

        roofW = Double.parseDouble(roofWT.getText());
        System.out.println(roofW + "m Width");

        roofH = Double.parseDouble(roofHT.getText());
        System.out.println(roofH + "m Height");

        powerCons = Integer.parseInt(powerConsT.getText());
        System.out.println(powerCons + " Watts");
    }
}