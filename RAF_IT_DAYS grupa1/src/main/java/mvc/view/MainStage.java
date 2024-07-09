package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.BtnPretrazi;
import mvc.controller.BtnPromeniStatus;
import mvc.controller.BtnSnimi;
import mvc.controller.BtnUpisiPredavaca;
import mvc.model.Kategorija;
import mvc.model.Predavac;
import mvc.model.Teme;

import java.util.Collection;

public class MainStage extends Stage {
    private static MainStage instance;

    private ComboBox<String> cbStatus = new ComboBox<>();

    private Button btnPretrazi = new Button("Pretrazi");
    private Button btnPromeniStatus = new Button("Promeni status");

    private TableView<Predavac> tvPredavaci = new TableView<>();

    private ListView<Teme> lvTeme = new ListView<>();

    private Label lbTeme = new Label("Teme:");

    private Button btnStatistika = new Button("Statistika");
    private Button btnSnimi = new Button("Snimi");
    private Button btnUpisiPredavaca = new Button("Upisi predavaca");

    private Label lbPredavacnema = new Label("Predavac nema dovoljno iskustva u oblasti");
    private Label lbDodeljeneTeme = new Label("Dodeljene teme predavacima: ");

    private TableView<Kategorija> tvKategorija = new TableView<>();

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
        super.setTitle("Gostovanja");

        btnPretrazi.setOnAction(new BtnPretrazi(this));
        btnPromeniStatus.setOnAction(new BtnPromeniStatus(this));
        btnUpisiPredavaca.setOnAction(new BtnUpisiPredavaca(this));
        btnSnimi.setOnAction(new BtnSnimi(this));

        TableColumn<Predavac, String> tcImePrez = new TableColumn<>("Ime i prezime");
        TableColumn<Predavac, String> tcKompanija = new TableColumn<>("Kompanija");

        TableColumn<Kategorija,String>tcPredavac=new TableColumn<>("Predavac");
        TableColumn<Kategorija,String>tcNazic=new TableColumn<>("Naziv predavanja");
        TableColumn<Kategorija,String>tcOblast=new TableColumn<>("Oblst");

        tcPredavac.setCellValueFactory(new PropertyValueFactory<>("predavac")); // use "pred" to match getPred method
        tcNazic.setCellValueFactory(new PropertyValueFactory<>("naziv")); // use "pred" to match getPred method
        tcOblast.setCellValueFactory(new PropertyValueFactory<>("oblast")); // use "pred" to match getPred method

         tvKategorija.getColumns().addAll(tcPredavac,tcNazic,tcOblast);

        tcImePrez.setCellValueFactory(new PropertyValueFactory<>("pred")); // use "pred" to match getPred method
        tcKompanija.setCellValueFactory(new PropertyValueFactory<>("kompanija"));

        tvPredavaci.getColumns().addAll(tcImePrez, tcKompanija);
        ///: POTVRDJEN, ODBIJEN, NA CEKANJU i RASPOREDJEN
        cbStatus.getItems().addAll("POTVRDJEN","ODBIJEN","NA CEKANJU","RASPOREDJEN");
        cbStatus.getSelectionModel().select(0);

        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.BOTTOM_LEFT);
        hb1.setSpacing(3);
        hb1.getChildren().addAll(cbStatus, btnPretrazi, btnPromeniStatus, lbTeme);

        VBox vb1 = new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(3);
        vb1.setPadding(new Insets(30, 20, 30, 20));
        vb1.getChildren().addAll(btnStatistika, btnSnimi, btnUpisiPredavaca);

        HBox hb2 = new HBox();
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(3);
        hb2.setPadding(new Insets(30, 20, 30, 20));
        hb2.getChildren().addAll(tvPredavaci, lvTeme, vb1);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(3);
        root.setPadding(new Insets(30, 20, 30, 20));
        root.getChildren().addAll(hb1, hb2, lbPredavacnema, lbDodeljeneTeme, tvKategorija);

        Scene scene = new Scene(root, 800, 700);
        super.setScene(scene);
    }

    public void insertPredavac(Collection<Predavac> pr) {
        tvPredavaci.getItems().clear();
        tvPredavaci.getItems().addAll(pr);
    }

    public void insertTeme(Collection<Teme> pr) {
        lvTeme.getItems().clear();
        lvTeme.getItems().addAll(pr);
    }
    public void insertKategorija(Collection<Kategorija> pr) {
        tvKategorija.getItems().clear();
        tvKategorija.getItems().addAll(pr);
    }

    public ComboBox<String> getCbStatus() {
        return cbStatus;
    }

    public TableView<Predavac> getTvPredavaci() {
        return tvPredavaci;
    }

    public ListView<Teme> getLvTeme() {
        return lvTeme;
    }

    public TableView<Kategorija> getTvKategorija() {
        return tvKategorija;
    }
}
