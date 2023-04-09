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


    public void onLoginButtonPressed(ActionEvent event) throws IOException {


        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin")) {
            openMainMenu(event);
        } else if ((username.equals("user") && password.equals("user"))) {
            openViewOrder(event);
        }
        else if (username.isEmpty() || password.isEmpty()) {
            invalidLoginLabel.setText("Please enter your credentials fully.");
            invalidLoginLabel.setVisible(true);
            invalidLoginLabel.setManaged(true);
        }
        else {
            invalidLoginLabel.setText("Invalid credentials, please try again");
            invalidLoginLabel.setVisible(true);
            invalidLoginLabel.setManaged(true);
        }


    }

    private void openMainMenu(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-menu.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setResizable(false);

        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();

    }
    public void openViewOrder(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view-order.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setResizable(false);

        stage.setTitle("View Order");
        stage.setScene(scene);
        stage.show();

    }
}
