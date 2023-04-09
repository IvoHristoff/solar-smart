package nl.saxion.re.solarsmart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.text.DecimalFormat;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import static java.lang.Math.floor;


public class SolarSmartController {

    /* --"T"-- stands for TextField */
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
    public ToggleGroup toggleShade = new ToggleGroup();
    @FXML
    public ToggleGroup togglePhase = new ToggleGroup();
    @FXML
    public RadioButton onshadeNo = new RadioButton();
    @FXML
    public RadioButton onshadeYes = new RadioButton();
    @FXML
    public RadioButton onphaseYes = new RadioButton();
    @FXML
    public RadioButton onphaseNo = new RadioButton();
    @FXML
    public Button confirm = new Button();
    @FXML
    public Button backButton = new Button();
    /* ------------------------------------ */
    public TextArea textArea;
    public String firstName;
    public String lastName;
    public double roofW;
    public double roofH;
    public int powerCons;
    public boolean shadeRoof = true;
    public boolean phaseConnector = false;
    public Stage stage;

    public void onConfirm(ActionEvent event) {
        double panelW = 1.754;
        double panelH = 1.096;
        int panelWatts = 405;

        firstName = firstNameT.getText();
        lastName = lastNameT.getText();
        textArea.appendText("Mr/Ms " + firstName + " " + lastName + "\n");

        roofW = Double.parseDouble(roofWT.getText());
        textArea.appendText(roofW + "m Width" + "\n");

        roofH = Double.parseDouble(roofHT.getText());
        textArea.appendText(roofH + "m Height" + "\n");

        powerCons = Integer.parseInt(powerConsT.getText());
        textArea.appendText(powerCons + " Watts" + "\n");

        /* ----- formatting the double's numbers after the comma to the second one ---- */
        double roofArea = roofH*roofW;
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedroofArea = df.format(roofArea);

        /* -----this code prints in the textarea---- */
        /* !!! (IT DOES SHOW ONLY AFTER THE FIRST TIME THE CONFIRM BUTTON IS CLICKED) !!! */
        int numberOfPanels = (int) (floor(roofW/panelW)*floor(roofH/panelH));
        /* for some reason shadeRoof is switched, but it works */
        int kwhPerYear = (int) (numberOfPanels * panelWatts * (this.shadeRoof? 0.8: 0.5));
        /* if button is clicked, then add 3m additional or whatever, else */
        textArea.appendText("The total roof area is: "+ formattedroofArea + " m2." + "\n");
        textArea.appendText("Number of panels to fit: "+ numberOfPanels + "\n");
        textArea.appendText("Power output of the panels: "+ kwhPerYear);
        textArea = new TextArea();
        textArea.setEditable(false);

    }
    public void onShadeToggle() {
        /*/ Create the RadioButtons and add them to the ToggleGroup */
        this.onshadeNo.setToggleGroup(this.toggleShade);
        this.onshadeYes.setToggleGroup(this.toggleShade);

        /* Check which RadioButton is selected */
        RadioButton selectedRadioButton = (RadioButton) this.toggleShade.getSelectedToggle();
        String selectedText = selectedRadioButton.getText();
        this.shadeRoof = selectedText.equals("yes");
    }

    public void onPhaseToggle() {
        /* Create the RadioButtons and add them to the ToggleGroup */
        this.onphaseNo.setToggleGroup(this.togglePhase);
        this.onphaseYes.setToggleGroup(this.togglePhase);

        /* Check which RadioButton is selected */
        RadioButton selectedRadioButton = (RadioButton) this.togglePhase.getSelectedToggle();
        String selectedText = selectedRadioButton.getText();
        this.phaseConnector = selectedText.equals("yes");

    }

    public void switchToMenu(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-menu.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);

        stage.setTitle("Main menu");
        stage.setScene(scene);
        stage.show();

    }




}