package nl.saxion.re.solarsmart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage {


    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label invalidLoginLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void onLoginButtonPressed(ActionEvent event) throws IOException {


        String username = usernameField.getText();
        String password = passwordField.getText();

        if (loginInfoCheck(username, password)) {
            openMainMenu(event);
        }
        else
        {
            invalidLoginLabel.setText("Invalid login information, please try again");
            invalidLoginLabel.setVisible(true);
            invalidLoginLabel.setManaged(true);
        }





    }

    private void openMainMenu(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-menu.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);

        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();

    }


    private boolean loginInfoCheck (String username, String password) {

        //Program is hardcoded for admin login credentials, it can be easily modified for having different users

        if (username.equals("admin") && password.equals("AdminPassword12345")){

            return true;
        }
        else {
            return false;
        }

    }

}
