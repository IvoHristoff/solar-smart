package nl.saxion.re.solarsmart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.PrintStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.PrintStream;
import javafx.scene.control.TextArea;


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
    @FXML
    public RadioButton onshadeNo = new RadioButton();
    @FXML
    public RadioButton onshadeYes = new RadioButton();
    @FXML
    public RadioButton onphaseYes = new RadioButton();
    @FXML
    public RadioButton onphaseNo = new RadioButton();

    @FXML
    public TextArea calculations;
    // ------------------------------------ //
    public String firstName;
    public String lastName;
    public double roofW;
    public double roofH;
    public int powerCons;
    public boolean shadeRoofYes = true;
    public boolean shadeRoofNo = false;
    public boolean phaseConnector = false;

    public void onConfirm(ActionEvent event) {

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

        System.out.println("The total roof area is: "+ (roofH*roofW) + " m2.");

    }
}