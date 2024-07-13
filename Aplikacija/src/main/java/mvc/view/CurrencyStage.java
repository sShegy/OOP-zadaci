package mvc.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.BtnKonvertuj;
import mvc.controller.BtnLista;

import java.util.Collection;

public class CurrencyStage extends Stage {
    private static CurrencyStage instance;

    private Label lbCena=new Label("Cena");
    private TextField txCena=new TextField();

    private ComboBox<String> cbDrzava=new ComboBox<>();

    private TextField txKrajnaCena=new TextField();
    private Label lbImeValute=new Label();
    private Label lbDrzava=new Label();

    private Button btnPrebaci=new Button("Konvertuj");
    private Button btnLista=new Button("Tabela Currency");
    private CurrencyStage(){
        init();
    }
    public static CurrencyStage getInstance(){
        if (instance==null){
            instance=new CurrencyStage();
        }
        return instance;
    }
    private void init(){
        super.setTitle("Main Stage");

        btnPrebaci.setOnAction(new BtnKonvertuj(this));
        btnLista.setOnAction(new BtnLista(this));

        txKrajnaCena.setEditable(false);

        cbDrzava.setEditable(true);

        HBox hb1=new HBox();
        hb1.setSpacing(5);
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(lbCena,txCena,cbDrzava,btnPrebaci,btnLista);

        HBox hb2 =new HBox();
        hb2.setSpacing(20);
        hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(txKrajnaCena,lbImeValute,lbDrzava);

        VBox vb1=new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(5);
        vb1.getChildren().addAll(hb1,hb2);

        Scene scene=new Scene(vb1,800,300);
        super.setScene(scene);

    }
    public void inserCbDrzave(Collection<String>rt){
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
