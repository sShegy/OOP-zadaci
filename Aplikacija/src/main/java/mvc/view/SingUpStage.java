package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import mvc.controller.BtnMakeAc;
import mvc.controller.BtnReturnToMainStage;

public class SingUpStage extends Stage {
    private static SingUpStage instance;

    private Label lbIme = new Label("Ime: ");
    private Label lbPrez = new Label("Prezime: ");
    private Label lbEmail = new Label("Email: ");
    private Label lbPassword = new Label("Password: ");

    private ChoiceBox<String> cbgender = new ChoiceBox<>();
    private DatePicker datePicker = new DatePicker();

    private TextField txIme = new TextField();
    private TextField txPrez = new TextField();
    private TextField txEmail = new TextField();
    private TextField txPassoword = new TextField();

    private Button btnMakeAc = new Button("Make account");
    private Button btnReturn = new Button("Return to Main Stage");

    private SingUpStage() {
        init();
    }

    public static SingUpStage getInstance() {
        if (instance == null) {
            instance = new SingUpStage();
        }
        return instance;
    }

    private void init() {
        super.setTitle("Sign up");

        btnReturn.setOnAction(new BtnReturnToMainStage(this));
        btnMakeAc.setOnAction(new BtnMakeAc(this));

        cbgender.getItems().addAll("Male", "Female");
        cbgender.getSelectionModel().select(0);

        // Styling Labels
        styleLabel(lbIme);
        styleLabel(lbPrez);
        styleLabel(lbEmail);
        styleLabel(lbPassword);

        // Styling TextFields
        styleTextField(txIme);
        styleTextField(txPrez);
        styleTextField(txEmail);
        styleTextField(txPassoword);

        // Styling Buttons
        styleButton(btnMakeAc, "#4CAF50", "#FFFFFF", 200);  // Increase button width
        styleButton(btnReturn, "#2196F3", "#FFFFFF", 200);  // Increase button width

        // GridPane setup
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(20, 10, 20, 10));
        gp.setHgap(10);
        gp.setVgap(10);

        gp.add(lbIme, 0, 0);
        gp.add(txIme, 1, 0);
        gp.add(lbPrez, 0, 1);
        gp.add(txPrez, 1, 1);
        gp.add(lbEmail, 0, 2);
        gp.add(txEmail, 1, 2);
        gp.add(lbPassword, 0, 3);
        gp.add(txPassoword, 1, 3);

        // HBox for DatePicker and ChoiceBox
        HBox hbBottom = new HBox(10);
        hbBottom.setAlignment(Pos.CENTER);
        hbBottom.getChildren().addAll(datePicker, cbgender);

        // VBox for the entire layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(gp, hbBottom, btnMakeAc, btnReturn);

        Scene scene = new Scene(root, 400, 500);
        super.setScene(scene);
    }

    private void styleLabel(Label label) {
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        label.setTextFill(Color.DARKSLATEGRAY);
    }

    private void styleTextField(TextField textField) {
        textField.setPrefWidth(200);
        textField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5; -fx-padding: 5px;");
    }

    private void styleButton(Button button, String bgColor, String textColor, int width) {
        button.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        button.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor + "; -fx-background-radius: 5;");
        button.setPrefSize(width, 40);  // Set the button width to ensure text fits
    }

    public ChoiceBox<String> getCbgender() {
        return cbgender;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public TextField getTxIme() {
        return txIme;
    }

    public TextField getTxPrez() {
        return txPrez;
    }

    public TextField getTxEmail() {
        return txEmail;
    }

    public TextField getTxPassoword() {
        return txPassoword;
    }
}
