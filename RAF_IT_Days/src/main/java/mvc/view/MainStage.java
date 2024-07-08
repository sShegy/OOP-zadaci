package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.BtnDodaj;
import mvc.controller.BtnFilter;
import mvc.model.Kategorija;
import mvc.model.Predavac;
import mvc.model.Teme;

import java.util.Collection;

public class MainStage extends Stage {
    private static MainStage instance;

    private ComboBox<String> cbOblast = new ComboBox<>();
    private Button btnFilter = new Button("Filtriraj");

    private ListView<Predavac> lvPredavac = new ListView<>();
    private ListView<Teme> lvTeme = new ListView<>();

    private ChoiceBox<String> cbDani = new ChoiceBox<>();
    private ChoiceBox<String> cbPreVez = new ChoiceBox<>();

    private Label lbVremePocetka = new Label("Vreme pocetka");
    private Label lbPoruke = new Label("Poruka");

    private TextField txVreme = new TextField();

    private Button btnDodaj = new Button("Dodaj");
    private TableView<Kategorija> tvKategorija = new TableView<>();

    private Button btnSacuvaj = new Button("Sacuvaj");

    private MainStage() {
        init();
    }

    public static MainStage getInstance() {
        if (instance == null) {
            instance = new MainStage();
        }
        return instance;
    }

    private void init() {
        btnFilter.setOnAction(new BtnFilter(this));
        btnDodaj.setOnAction(new BtnDodaj(this));


        cbDani.getItems().addAll("Prvi dan", "Drugi dan", "Treci dan", "Cetvrti dan");
        cbPreVez.getItems().addAll("Predavanje", "Radionica");

        cbDani.getSelectionModel().select(0);
        cbPreVez.getSelectionModel().select(0);

        TableColumn<Kategorija, String> tcTema = new TableColumn<>("Tema");
        TableColumn<Kategorija, String> tcPredavac = new TableColumn<>("Predavac");
        TableColumn<Kategorija, String> tcKompanija = new TableColumn<>("Kompanija");
        TableColumn<Kategorija, String> tcDan = new TableColumn<>("Dan");
        TableColumn<Kategorija, Integer> tcVreme = new TableColumn<>("Vreme");
        TableColumn<Kategorija, String> tcVrsta = new TableColumn<>("Vrsta");

        tcTema.setCellValueFactory(new PropertyValueFactory<>("tema"));
        tcPredavac.setCellValueFactory(new PropertyValueFactory<>("predavac"));
        tcKompanija.setCellValueFactory(new PropertyValueFactory<>("kompanija"));
        tcDan.setCellValueFactory(new PropertyValueFactory<>("dan"));
        tcVreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));
        tcVrsta.setCellValueFactory(new PropertyValueFactory<>("vrsta"));

        tvKategorija.getColumns().addAll(tcTema, tcPredavac, tcKompanija, tcDan, tcVreme, tcVrsta);

        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(3);
        hb1.setPadding(new Insets(30, 20, 30, 20));
        hb1.getChildren().addAll(cbOblast, btnFilter);

        HBox hb2 = new HBox();
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(2);
        hb2.getChildren().addAll(lvPredavac, lvTeme);

        HBox hb3 = new HBox();
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(3);
        hb3.setPadding(new Insets(30, 20, 30, 20));
        hb3.getChildren().addAll(cbDani, cbPreVez, lbVremePocetka, txVreme, btnDodaj);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(3);
        root.setPadding(new Insets(30, 20, 30, 20));
        root.getChildren().addAll(hb1, hb2, hb3, lbPoruke, tvKategorija, btnSacuvaj);

        Scene scene = new Scene(root, 600, 700);
        super.setScene(scene);
    }

    public void insertLvPredavac(Collection<Predavac> pr) {
        lvPredavac.getItems().clear();
        lvPredavac.getItems().addAll(pr);
    }

    public void insertLvTeme(Collection<Teme> ty) {
        lvTeme.getItems().clear();
        lvTeme.getItems().addAll(ty);
    }

    public void insertCbOblast(Collection<String> pr) {
        cbOblast.getItems().clear();
        cbOblast.getItems().addAll(pr);
        cbOblast.getSelectionModel().select(0);
    }

    public void insertKategorija(Collection<Kategorija> pr) {
        tvKategorija.getItems().clear();
        tvKategorija.getItems().addAll(pr);
    }

    public ComboBox<String> getCbOblast() {
        return cbOblast;
    }

    public ListView<Teme> getLvTeme() {
        return lvTeme;
    }

    public ListView<Predavac> getLvPredavac() {
        return lvPredavac;
    }

    public TextField getTxVreme() {
        return txVreme;
    }

    public ChoiceBox<String> getCbPreVez() {
        return cbPreVez;
    }

    public ChoiceBox<String> getCbDani() {
        return cbDani;
    }

    public TableView<Kategorija> getTvKategorija() {
        return tvKategorija;
    }
}
