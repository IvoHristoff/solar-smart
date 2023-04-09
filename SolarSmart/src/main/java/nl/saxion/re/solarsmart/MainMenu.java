package nl.saxion.re.solarsmart;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {

    private Stage stage;
    private Scene scene;
    private Parent root;





    public void switchToCustomerDetails(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("customer-details.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);

        stage.setTitle("Customer details");
        stage.setScene(scene);
        stage.show();

    }

    public void switchToPartsList(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("parts-list.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setResizable(false);

        stage.setTitle("Parts List");
        stage.setScene(scene);
        stage.show();

    }
    public void switchToLoginPage(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-page.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setResizable(false);

        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();

    }
}
