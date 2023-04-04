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
    // --"T"-- stands for TextField //

    // @FXML
    // private Button myButton;
    String firstName;
    String lastName;
    double roofW;
    double roofH;
    int powerCons;


    public void confirm(ActionEvent event) {

        //try {
        firstName = myTextField.getText();
        lastName = myTextField.getText();
        roofW = Integer.parseInt(myTextField.getText());
        roofH = Integer.parseInt(myTextField.getText());
        powerCons = Integer.parseInt(myTextField.getText());

           /* if(age >= 18) {
                myLabel.setText("You are now signed up!");
            }
            else {

                myLabel.setText("You must be 18+");
          */
    }
}


