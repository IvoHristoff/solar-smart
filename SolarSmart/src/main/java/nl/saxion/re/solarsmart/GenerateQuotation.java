package nl.saxion.re.solarsmart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GenerateQuotation {
    private Stage stage;

    @FXML
    private TextArea textArea;

    public void switchToLoginPage(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-page.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image("CompanyLogo.PNG"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setResizable(false);

        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();

    }

    public void setData(Object data) {
        textArea.appendText(data.toString());
    }

    public void editText() {
        textArea.setEditable(true);
    }

    public void makeTextAreaEditable(ActionEvent event) {
        editText();
    }

    public void onSubmit(ActionEvent event) {
        Data.setEmail(textArea.getText());
    }
}
