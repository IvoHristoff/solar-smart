package nl.saxion.re.solarsmart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextFieldController {


    // --"T"-- stands for TextField //
    @FXML
    private Label T;
    @FXML
    private TextField firstNameT;
    private TextField lastNameT;
    private TextField roofWT;
    private TextField roofHT;
    private TextField powerConsT;
    private Button confirm;
    // --"T"-- stands for TextField //

    // @FXML
    // private Button myButton;
    String firstName;
    String lastName;
    double roofW;
    double roofH;
    int powerCons;

    @FXML
    public void onConfirm(ActionEvent event){

        //try {
        firstName = firstNameT.getText();
        lastName = lastNameT.getText();
        roofW = Double.parseDouble(roofWT.getText());
        roofH = Double.parseDouble(roofHT.getText());
        powerCons = Integer.parseInt(powerConsT.getText());

           /* if(age >= 18) {
                myLabel.setText("You are now signed up!");
            }
            else {

                myLabel.setText("You must be 18+");
          */
    }
}


