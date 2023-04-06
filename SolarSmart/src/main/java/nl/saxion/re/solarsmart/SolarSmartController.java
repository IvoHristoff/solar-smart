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
import java.text.DecimalFormat;

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
    public TextArea textArea;
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
        textArea.appendText("Mr/Ms " + firstName + "\n");

        lastName = lastNameT.getText();
        textArea.appendText(lastName + "\n");

        roofW = Double.parseDouble(roofWT.getText());
        textArea.appendText(roofW + "m Width" + "\n");

        roofH = Double.parseDouble(roofHT.getText());
        textArea.appendText(roofH + "m Height" + "\n");

        powerCons = Integer.parseInt(powerConsT.getText());
        textArea.appendText(powerCons + " Watts" + "\n");

        // ----- formatting the double's numbers after the comma to the second one ---- //
        double roofArea = roofH*roofW;
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedroofArea = df.format(roofArea);

        // -----this code prints in the textarea---- //
        // !!! (IT DOES SHOW ONLY AFTER THE FIRST TIME THE CONFIRM BUTTON IS CLICKED) !!! //
        textArea.appendText("The total roof area is: "+ formattedroofArea + " m2." + "\n");
        textArea = new TextArea();
        textArea.setEditable(false);
    }
}