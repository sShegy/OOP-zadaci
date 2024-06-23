package mvc.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.BrnOdgledaj;
import mvc.controller.BtnDodajKurs;
import mvc.model.Kategorija;
import mvc.model.Kurs;

import java.util.Collection;

public class MainStage extends Stage {
    private static MainStage instance;

    private Label lbrafCursera = new Label("RAF Cursera");

    private Label lbRaspolozivo = new Label("Raspolozivo");
    private Label lbRaspolozivoStaje = new Label();

    private Label lbDostupniKursevi = new Label("Dostupni kursevi");
    private Label lbMojiKursevi = new Label("Moji kursevi");

    private ListView<Kurs> lvKursevi = new ListView<>();
    private ListView<Kurs> lvOdKurseva = new ListView<>();

    private Label lbPocetakAktivnosti = new Label("Pocetak aktivnosti");

    private Label lbSati = new Label("Sati:");
    private ChoiceBox<Integer> cbSati = new ChoiceBox<>();

    private Label lbMinuti = new Label("Minuti:");
    private ChoiceBox<Integer> cbMinuti = new ChoiceBox<>();

    private Label lbTrajanjeAktiv = new Label("Trajanje aktivnosti");
    private TextField txTrajanjeAktivnosti = new TextField();

    private Label lbMax120 = new Label("(max 120 min)");

    private Button btnOdgledaj = new Button("Odgledaj");
    private Label lbStaseTrenutnogleda = new Label();

    private Button btnDodajKurs = new Button("Dodaj kurs");
    private Button btnSnimiAktivnost = new Button("Snimi aktivnost");

    private TableView<Kategorija> tvKursStaseGleda = new TableView<>();

    public MainStage() {
        init();
    }

    private void init() {
        super.setTitle("Ispit JUN");
        lbRaspolozivoStaje.setText("Cigan");

        btnDodajKurs.setOnAction(new BtnDodajKurs(this));
        btnOdgledaj.setOnAction(new BrnOdgledaj(this));

        TableColumn<Kategorija, String> tcNaziv = new TableColumn<>("Naziv");
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        TableColumn<Kategorija, String> tcKategorija = new TableColumn<>("Kategorija");
        tcKategorija.setCellValueFactory(new PropertyValueFactory<>("kategorija"));

        tvKursStaseGleda.getColumns().addAll(tcNaziv, tcKategorija);

        VBox vb1 = new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(5);
        vb1.getChildren().addAll(lbDostupniKursevi, lvKursevi);

        VBox vb2 = new VBox();
        vb2.setAlignment(Pos.CENTER);
        vb2.setSpacing(5);
        vb2.getChildren().addAll(lbMojiKursevi, lvOdKurseva);

        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(5);
        hb1.getChildren().addAll(lbSati, cbSati, lbMinuti, cbMinuti);

        HBox hb2 = new HBox();
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(5);
        hb2.getChildren().addAll(txTrajanjeAktivnosti, lbMax120);

        HBox hb4 = new HBox();
        hb4.setAlignment(Pos.CENTER);
        hb4.setSpacing(1);
        hb4.getChildren().addAll(lbRaspolozivo, lbRaspolozivoStaje);

        VBox vb3 = new VBox();
        vb3.setAlignment(Pos.CENTER);
        vb3.setSpacing(5);
        vb3.getChildren().addAll(lbPocetakAktivnosti, hb1, lbTrajanjeAktiv, hb4, btnOdgledaj, lbStaseTrenutnogleda);

        HBox root1 = new HBox();
        root1.setAlignment(Pos.CENTER);
        root1.setSpacing(5);
        root1.getChildren().addAll(vb1, btnDodajKurs, vb2, vb3);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(5);
        root.getChildren().addAll(lbrafCursera, hb4, root1, tvKursStaseGleda, btnSnimiAktivnost);

        Scene scene = new Scene(root, 1000, 900);
        super.setScene(scene);
    }

    public void insertKurs(Collection<Kurs> kursevi) {
        lvKursevi.getItems().clear();
        lvKursevi.getItems().addAll(kursevi);
        lvKursevi.getSelectionModel().select(0);
    }

    public void insertKurslista(Collection<Kurs> kursevi) {
        lvOdKurseva.getItems().clear();
        lvOdKurseva.getItems().addAll(kursevi);
        lvOdKurseva.getSelectionModel().select(0);
    }

    public void insertSate(Collection<Integer> sati) {
        cbSati.getItems().clear();
        cbSati.getItems().addAll(sati);
        cbSati.getSelectionModel().select(0);
    }

    public void insertMinute(Collection<Integer> minuti) {
        cbMinuti.getItems().clear();
        cbMinuti.getItems().addAll(minuti);
        cbMinuti.getSelectionModel().select(0);
    }

    public void insertKategorije(Collection<Kategorija> kategorije) {
        tvKursStaseGleda.getItems().clear();
        tvKursStaseGleda.getItems().addAll(kategorije);
        tvKursStaseGleda.getSelectionModel().select(0);
    }

    public ListView<Kurs> getLvKursevi() {
        return lvKursevi;
    }

    public Label getLbStaseTrenutnogleda() {
        return lbStaseTrenutnogleda;
    }

    public Label getLbRaspolozivoStaje() {
        return lbRaspolozivoStaje;
    }

    public ListView<Kurs> getLvOdKurseva() {
        return lvOdKurseva;
    }
}
