package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;  // Import for Color
import javafx.scene.text.Font;  // Import for Font
import javafx.scene.text.FontWeight;  // Import for FontWeight
import mvc.controller.BtnFilterzaCurrencyTabelu;
import mvc.controller.BtnRemoveFilterzaTabelu;
import mvc.controller.BtnUzmi;
import mvc.model.Currency;

import java.util.Collection;

public class CurrencyStageList extends Stage {
    private static CurrencyStageList instance;

    private Label lbLista = new Label("Lista");

    private TableView<Currency> tvCurrency = new TableView<>();

    private ComboBox<String> cbDrzava = new ComboBox<>();

    private Button btnFilter = new Button("Filter");
    private Button btnUzim = new Button("Uzmi valutu i konvertuj");
    private Button btnRemoveFIlter = new Button("Skloni filter");

    private CurrencyStageList() {
        init();
    }

    public static CurrencyStageList getInstance() {
        if (instance == null) {
            instance = new CurrencyStageList();
        }
        return instance;
    }

    public void init() {
        super.setTitle("Tabela Currency");

        cbDrzava.setEditable(true);
        btnFilter.setOnAction(new BtnFilterzaCurrencyTabelu(this));
        btnRemoveFIlter.setOnAction(new BtnRemoveFilterzaTabelu(this));
        btnUzim.setOnAction(new BtnUzmi(this));

        TableColumn<Currency, Double> tcCena = new TableColumn<>("Iznos");
        TableColumn<Currency, String> tcImeValute = new TableColumn<>("Valuta");
        TableColumn<Currency, String> tcDrzava = new TableColumn<>("Drzava");

        tcCena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tcImeValute.setCellValueFactory(new PropertyValueFactory<>("nameCurrency"));
        tcDrzava.setCellValueFactory(new PropertyValueFactory<>("drzava"));

        tvCurrency.getColumns().addAll(tcCena, tcImeValute, tcDrzava);

        // Apply styles
        styleLabel(lbLista);
        styleComboBox(cbDrzava);
        styleButton(btnFilter, "#4CAF50", "#FFFFFF");
        styleButton(btnRemoveFIlter, "#FF6F61", "#FFFFFF");
        styleButton(btnUzim, "#2196F3", "#FFFFFF");
        styleTable(tvCurrency);

        HBox hb1 = new HBox(10);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(10);
        hb1.setPadding(new Insets(10, 5, 10, 5));
        hb1.getChildren().addAll(cbDrzava, btnFilter, btnRemoveFIlter);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(7);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(lbLista, hb1, tvCurrency, btnUzim);

        Scene scene = new Scene(root, 500, 600);
        super.setScene(scene);
    }

    private void styleLabel(Label label) {
        label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        label.setTextFill(Color.DARKSLATEGRAY);
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

    private void styleTable(TableView<Currency> tableView) {
        tableView.setStyle("-fx-font-size: 14px;");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setPrefHeight(400);
    }

    public void insertTabela(Collection<Currency> tr) {
        tvCurrency.getItems().clear();
        tvCurrency.getItems().addAll(tr);
    }

    public void insertcb(Collection<String> tr) {
        cbDrzava.getItems().clear();
        cbDrzava.getItems().addAll(tr);
    }

    public ComboBox<String> getCbDrzava() {
        return cbDrzava;
    }

    public TableView<Currency> getTvCurrency() {
        return tvCurrency;
    }
}
