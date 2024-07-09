package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.model.Kategorija;
import mvc.model.Vozila;

import java.util.Collection;

public class MainStage extends Stage {
    private static MainStage instance;

    private Label lbTipovi = new Label("Tipovi:");
    private Label lbRenta = new Label("RENT-A-CAR");

    private ListView<Vozila> lvVozila = new ListView<>();

    private Label lbOdaberi = new Label("Odaberite period rentanja:");

    private TextField txDatum = new TextField();
    private TextField txDatum2 = new TextField();

    private Label lbcrta = new Label(" - ");

    private Button btnPretrazi = new Button("Pretrazi");

    private Label lbDostupno = new Label("Dostupno za odabrani period:");

    private TableView<Kategorija> tvKategorija = new TableView<>();

    private Label lbCenalb = new Label("Cena za odabrani auto i period: ");
    private Label lbCENA = new Label();

    private Button btnRezervisi = new Button("Rezervisi");

    private Button btnSverezervacije = new Button("Sve rezervacije");

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
        super.setTitle("Ispit Jul");

        VBox vb1 = new VBox();
        vb1.setSpacing(2);
        vb1.setAlignment(Pos.CENTER_LEFT);
        vb1.setPadding(new Insets(10, 5, 10, 5));
        vb1.getChildren().addAll(lbTipovi, lvVozila);

        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setAlignment(Pos.CENTER);
        hb1.setPadding(new Insets(10, 10, 10, 10));
        hb1.getChildren().addAll(txDatum, lbcrta, txDatum2, btnPretrazi);

        VBox vb2 = new VBox();
        vb2.setSpacing(5);
        vb2.setPadding(new Insets(10, 10, 10, 10));
        vb2.getChildren().addAll(lbOdaberi, hb1);

        HBox hb2 = new HBox();
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(10, 10, 10, 10));
        hb2.getChildren().addAll(vb1, vb2);

        VBox vb3 = new VBox();
        vb3.setSpacing(5);
        vb3.setAlignment(Pos.CENTER);
        vb3.getChildren().addAll(lbCenalb, lbCENA);

        VBox vb4 = new VBox();
        vb4.setSpacing(5);
        vb4.setAlignment(Pos.BOTTOM_LEFT);
        vb4.getChildren().addAll(btnSverezervacije);

        VBox root = new VBox();
        root.setSpacing(7);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 20, 10, 20));
        root.getChildren().addAll(lbRenta, hb2, lbDostupno, tvKategorija, vb3, btnRezervisi, vb4);

        Scene scene = new Scene(root, 600, 500);
        super.setScene(scene);
    }
    public void inserLvVozila(Collection<Vozila>v){
        lvVozila.getItems().clear();
        lvVozila.getItems().addAll(v);
        lvVozila.getSelectionModel().select(0);
    }

}
