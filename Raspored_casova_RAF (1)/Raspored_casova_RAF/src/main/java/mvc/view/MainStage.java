package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.PrikaziController;
import mvc.model.Termin;

import java.util.Collection;

public class MainStage extends Stage {
    private static MainStage instance;

    private ComboBox<String> cbGrupa = new ComboBox<>();
    private Label lbUkupan = new Label();
    private TableView<Termin> tvRaspored = new TableView<>();

    private Button btnStatika = new Button("Statistika");
    private Button btnPrikazi = new Button("Prikazi");
    private Button btnStampa = new Button("Stampa");

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
        TableColumn<Termin, String> tcPredmet = new TableColumn<>("Predmet");
        tcPredmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));

        TableColumn<Termin, String> tcNastavnik = new TableColumn<>("Nastavnik");
        tcNastavnik.setCellValueFactory(new PropertyValueFactory<>("nastavnik"));

        TableColumn<Termin, String> tcVrsta = new TableColumn<>("Vrsta");
        tcVrsta.setCellValueFactory(new PropertyValueFactory<>("vrsta"));

        TableColumn<Termin, String> tcUcionica = new TableColumn<>("Ucionica");
        tcUcionica.setCellValueFactory(new PropertyValueFactory<>("ucionica"));

        TableColumn<Termin, String> tcTermin = new TableColumn<>("Termin");
        tcTermin.setCellValueFactory(new PropertyValueFactory<>("termin"));

        TableColumn<Termin, String> tcDan = new TableColumn<>("Dan");
        tcDan.setCellValueFactory(new PropertyValueFactory<>("dan"));

        tvRaspored.getColumns().addAll(tcPredmet, tcNastavnik, tcVrsta, tcUcionica, tcTermin, tcDan);


        btnPrikazi.setOnAction(new PrikaziController());

        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(5);
        hb1.getChildren().addAll(cbGrupa, btnPrikazi, lbUkupan, btnStatika);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 10, 10, 20));
        root.setSpacing(4);
        root.getChildren().addAll(hb1, tvRaspored, btnStampa);

        Scene scene = new Scene(root, 650, 500);
        super.setScene(scene);
    }

    public void insertTermini(Collection<Termin> termini) {
        tvRaspored.getItems().clear();
        tvRaspored.getItems().addAll(termini);
        tvRaspored.getSelectionModel().select(0);
    }

    public void insertGrupe(Collection<String> grupe){
        cbGrupa.getItems().clear();
        cbGrupa.getItems().addAll(grupe);
        cbGrupa.getSelectionModel().select(0);
    }

    public void setBrojGrupa(int brojGrupa) {
        lbUkupan.setText("Ukupan broj grupa: " + brojGrupa);
    }

    public String getGrupa() {
        return cbGrupa.getSelectionModel().getSelectedItem();
    }
}