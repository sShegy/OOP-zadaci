package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.model.Raspored;
import mvc.model.Raspored_pogrupama;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainStage extends Stage {
    private static MainStage instance;

    private ComboBox<String> cbGrupa = new ComboBox<>();

    private Button btnPrikazi = new Button("Prikazi");

    private Label lbUkupan = new Label("Ukupan broj grupa: ");
    private Label lbBrojGrupa = new Label();

    private Button btnStatika = new Button("Statistika");

    private TableView<Raspored> tvRaspored = new TableView<>();

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
        TableColumn<Raspored, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<Raspored, String> tcDan = new TableColumn<>("Dan");
        TableColumn<Raspored, String> tcUcionica = new TableColumn<>("Ucionica");
        TableColumn<Raspored, String> tcTermin = new TableColumn<>("Termin");
        TableColumn<Raspored, String> tcVrsta = new TableColumn<>("Vrsta");

        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcDan.setCellValueFactory(new PropertyValueFactory<>("dan"));
        tcUcionica.setCellValueFactory(new PropertyValueFactory<>("ucionica"));
        tcTermin.setCellValueFactory(new PropertyValueFactory<>("termin"));
        tcVrsta.setCellValueFactory(new PropertyValueFactory<>("vrsta"));

        tvRaspored.getColumns().addAll(tcNaziv, tcDan, tcUcionica, tcTermin, tcVrsta);

        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(5);
        hb1.getChildren().addAll(cbGrupa, btnPrikazi, lbUkupan, lbBrojGrupa, btnStatika);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 10, 10, 20));
        root.setSpacing(4);
        root.getChildren().addAll(hb1, tvRaspored, btnStampa);

        Scene scene = new Scene(root, 500, 400);
        super.setScene(scene);
    }

    public void insertRaspored(Collection<Raspored_pogrupama> rt) {
        tvRaspored.getItems().clear();
        List<Raspored> flatList = new ArrayList<>();
        for (Raspored_pogrupama rp : rt) {
            flatList.addAll(rp.getRaspored());
        }
        tvRaspored.getItems().addAll(flatList);
    }

    public void inserCbbox(Collection<String>pr){
        cbGrupa.getItems().clear();
        cbGrupa.getItems().addAll(pr);
        cbGrupa.getSelectionModel().select(0);
    }
}