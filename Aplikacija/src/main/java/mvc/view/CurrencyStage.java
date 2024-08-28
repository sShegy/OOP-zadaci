package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import mvc.controller.BtnBack2;
import mvc.controller.BtnKonvertuj;
import mvc.controller.BtnLista;

import java.util.Collection;

public class CurrencyStage extends Stage {
    private static CurrencyStage instance;

    private Label lbCena = new Label("Cena");
    private TextField txCena = new TextField();

    private ComboBox<String> cbDrzava = new ComboBox<>();

    private TextField txKrajnaCena = new TextField();
    private Label lbImeValute = new Label();
    private Label lbDrzava = new Label();

    private Button btnBack = new Button("Back");
    private Button btnPrebaci = new Button("Konvertuj");
    private Button btnLista = new Button("Tabela Currency");

    private CurrencyStage() {
        init();
    }

    public static CurrencyStage getInstance() {
        if (instance == null) {
            instance = new CurrencyStage();
        }
        return instance;
    }

    private void init() {
        super.setTitle("Currency Converter");

        btnPrebaci.setOnAction(new BtnKonvertuj(this));
        btnLista.setOnAction(new BtnLista(this));
        btnBack.setOnAction(new BtnBack2(this));

        txKrajnaCena.setEditable(false);
        cbDrzava.setEditable(true);

        // Apply styles
        styleLabel(lbCena);
        styleLabel(lbImeValute);
        styleLabel(lbDrzava);
        styleTextField(txCena);
        styleTextField(txKrajnaCena);
        styleComboBox(cbDrzava);
        styleButton(btnBack, "#FF6F61", "#FFFFFF");
        styleButton(btnPrebaci, "#4CAF50", "#FFFFFF");
        styleButton(btnLista, "#2196F3", "#FFFFFF");

        // Layout adjustments
        HBox hb1 = new HBox(10);  // Increased spacing for better readability
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(lbCena, txCena, cbDrzava, btnPrebaci, btnLista);

        HBox hb2 = new HBox(20);  // Increased spacing between elements
        hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(txKrajnaCena, lbImeValute, lbDrzava);

        VBox vb1 = new VBox(15);  // Increased vertical spacing between rows
        vb1.setAlignment(Pos.CENTER);
        vb1.setPadding(new Insets(20, 20, 20, 20));  // Added padding around VBox
        vb1.getChildren().addAll(hb1, hb2, btnBack);

        Scene scene = new Scene(vb1, 800, 300);
        super.setScene(scene);
    }

    private void styleLabel(Label label) {
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        label.setTextFill(Color.DARKSLATEGRAY);
    }

    private void styleTextField(TextField textField) {
        textField.setPrefWidth(150);
        textField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5; -fx-padding: 5px;");
    }

    private void styleComboBox(ComboBox<String> comboBox) {
        comboBox.setPrefWidth(150);
        comboBox.setStyle("-fx-font-size: 14px; -fx-background-radius: 5;");
    }

    private void styleButton(Button button, String bgColor, String textColor) {
        button.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        button.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor + "; -fx-background-radius: 5;");
        button.setPrefSize(150, 40);
    }

    public void inserCbDrzave(Collection<String> rt) {
        cbDrzava.getItems().clear();
        cbDrzava.getItems().addAll(rt);
        cbDrzava.getSelectionModel().select(0);
    }

    public ComboBox<String> getCbDrzava() {
        return cbDrzava;
    }

    public TextField getTxKrajnaCena() {
        return txKrajnaCena;
    }

    public Label getLbImeValute() {
        return lbImeValute;
    }

    public TextField getTxCena() {
        return txCena;
    }

    public Label getLbDrzava() {
        return lbDrzava;
    }
}
