package nl.saxion.re.solarsmart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static java.lang.Math.floor;


public class SolarSmartController {

    /* --"T"-- stands for TextField */
    @FXML
    public TextField userAddressT;
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
    @FXML
    public DatePicker datePicker = new DatePicker();
    /* ------------------------------------ */
    public TextArea textArea;
    private String text;
    public String firstName;
    public String lastName;
    public double roofW;
    public double roofH;
    public int powerConsummation;
    public boolean shadeRoof;
    public boolean phaseConnector = false;
    public Stage stage;
    public double totalPrice;
    public int priceSb2000 = 400;
    public int priceSb5000 = 600;
    public int priceSb6000 = 800;
    public int priceSb8000 = 1000;
    public int priceSb12000 = 1500;
    double panelPrice = 200;
    double panelW = 1.754;
    double panelH = 1.096;
    int panelWatts = 405;
    int numberOfPanels;
    int kwhPerYear;
    int fixedPriceInstall = 1000;
    String userAddress;


    public void onConfirm(ActionEvent event) {

        this.text = "";

        this.firstName = firstNameT.getText();
        this.lastName = lastNameT.getText();
        this.text += "Mr/Ms " + firstName + " " + lastName + "\n";

        this.userAddress = userAddressT.getText();

        roofW = Double.parseDouble(roofWT.getText());
        this.text += roofW + "m Width" + "\n";

        roofH = Double.parseDouble(roofHT.getText());
        this.text += roofH + "m Height" + "\n";

        powerConsummation = Integer.parseInt(powerConsT.getText());
        this.text += powerConsummation + " Watts" + "\n";


        /* ----- formatting the double's numbers after the comma to the second one ---- */
        double roofArea = this.roofH * this.roofW;
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedroofArea = df.format(roofArea);

        this.numberOfPanels = (int) (floor(this.roofW/this.panelW)*floor(this.roofH/this.panelH));
        this.kwhPerYear = (int) (this.numberOfPanels * this.panelWatts * (this.shadeRoof? 0.5: 0.8));

        this.text += "The address is: "+ userAddress + "\n";
        this.text += "The total roof area is: "+ formattedroofArea + " m2." + "\n";
        this.text += "Number of panels to fit: "+ this.numberOfPanels + "\n";
        this.text += "Power output of the panels: "+ this.kwhPerYear + "W\n";
        this.text += "Total price for everything: "+ this.sumPrice(true) + " EUR\n";
        this.text += "Selected Date: " + this.datePicker.getValue();


        displayTextArea();
    }

    public void displayTextArea() {
        this.textArea.clear();
        this.textArea.appendText(this.text);
    }

    public void onShadeToggle() {
        /* Create the RadioButtons and add them to the ToggleGroup */
        this.onshadeNo.setToggleGroup(this.toggleShade);
        this.onshadeYes.setToggleGroup(this.toggleShade);

        /* Check which RadioButton is selected */
        RadioButton selectedRadioButton = (RadioButton) this.toggleShade.getSelectedToggle();
        String selectedText = selectedRadioButton.getText();
        this.shadeRoof = selectedText.equals("Yes");
    }

    public void onPhaseToggle() {
        /* Create the RadioButtons and add them to the ToggleGroup */
        this.onphaseNo.setToggleGroup(this.togglePhase);
        this.onphaseYes.setToggleGroup(this.togglePhase);

        /* Check which RadioButton is selected */
        RadioButton selectedRadioButton = (RadioButton) this.togglePhase.getSelectedToggle();
        String selectedText = selectedRadioButton.getText();
        this.phaseConnector = selectedText.equals("Yes");

    }

    public void switchToMenu(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-menu.fxml"));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image("CompanyLogo.PNG"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setResizable(false);

        stage.setTitle("Main menu");
        stage.setScene(scene);
        stage.show();

    }

    public void onContinue(ActionEvent event) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("generate-quotation.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 500);

        scene.setUserData(
                "Dear " + this.firstName + " " + this.lastName + "," + "\n" +
                "\n" +
                "We hereby present you the quotation for your order: \n" +
                "\n" +
                "We can fit " + this.numberOfPanels + " panels on your roof," + "\n" +
                "generating a total of " + this.kwhPerYear + "kWh.\n" +
                "\n" +
                "This would cost a total amount of "+ "\n" +
                this.sumPrice(true) + " EUR (INCL 21% VAT).\n" +
                "\n" +
                "Our staff will come at " + this.userAddress +  "\n"+
                "on the desired installation date " + this.datePicker.getValue() + ".\n"+
                "\n" +
                "If there are any questions or comments,\n" +
                "feel free to let us know." + "\n"+
                "\n" +
                "Kind regards,\n" +
                "Your ECRC Solar panels consulting team.\n"+
                "\n" +
                "+31 612345678\n"
        );

        GenerateQuotation targetController = fxmlLoader.getController();
        targetController.setData(scene.getUserData());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image("CompanyLogo.PNG"));
        stage.setResizable(false);

        stage.setTitle("Quotation for Customer");
        stage.setScene(scene);
        stage.show();

    }

    public void editText() {
        textArea.setEditable(true);
    }

    public void makeTextAreaEditable(ActionEvent event) {
        editText();
    }

    public double sumPrice(boolean vat) {
        this.totalPrice = (this.numberOfPanels * this.panelPrice) + (numberOfPanels*50) + fixedPriceInstall;

        if (powerConsummation >= 12000) {
            this.totalPrice += 1500;
        }
        else if (powerConsummation >= 8000) {
            this.totalPrice += 1000;
        }
        else if (powerConsummation >= 6000) {
            this.totalPrice += 800;
        }
        else if (powerConsummation >= 5000) {
            this.totalPrice += 600;
        }
        else if (powerConsummation >= 2000) {
            this.totalPrice += 400;
        }

        if (phaseConnector){
            totalPrice += 800;
        }

        if (vat) {
            totalPrice *= 1.21;
        }

        return this.totalPrice;
    }



}