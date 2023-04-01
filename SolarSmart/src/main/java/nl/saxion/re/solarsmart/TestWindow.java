package nl.saxion.re.solarsmart;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TestWindow {

    @FXML
    private Pane panePicture;


    @FXML
    private void onPreviousButtonPressed() {

        String path = "/cat.jpg";

        panePicture.getChildren().clear();

        panePicture.getChildren().add(new ImageView(path));
    }

}
