module nl.saxion.re.solarsmart {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;

    opens nl.saxion.re.solarsmart to javafx.fxml;
    exports nl.saxion.re.solarsmart;
}