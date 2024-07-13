package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.BtnFilterzaCurrencyTabelu;
import mvc.controller.BtnRemoveFilterzaTabelu;
import mvc.controller.BtnUzmi;
import mvc.model.Currency;

import java.util.Collection;

public class CurrencyStageList extends Stage {
    private static CurrencyStageList instance;

    private Label lbLista=new Label("Lista");

    private TableView<Currency>tvCurrency=new TableView<>();

    private ComboBox<String>cbDrzava=new ComboBox<>();

    private Button btnFilter=new Button("Filter");
    private Button btnUzim=new Button("Uzmi valtu i konvertuj");
    private Button btnRemoveFIlter=new Button("Skloni filer");

    private CurrencyStageList() {
        init();
    }
    public static CurrencyStageList getInstance(){
        if (instance==null){
            instance=new CurrencyStageList();
        }
        return instance;
    }
    public void init(){
        super.setTitle("Tabela Currency");

        cbDrzava.setEditable(true);
        btnFilter.setOnAction(new BtnFilterzaCurrencyTabelu(this));
        btnRemoveFIlter.setOnAction(new BtnRemoveFilterzaTabelu(this));
        btnUzim.setOnAction(new BtnUzmi(this));

        TableColumn<Currency,Double>tcCena=new TableColumn<>("Iznos");
        TableColumn<Currency,String>tcImeValute=new TableColumn<>("Valuta");
        TableColumn<Currency,String>tcDrzava=new TableColumn<>("Drzava");

        tcCena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        tcImeValute.setCellValueFactory(new PropertyValueFactory<>("nameCurrency"));
        tcDrzava.setCellValueFactory(new PropertyValueFactory<>("drzava"));

        tvCurrency.getColumns().addAll(tcCena,tcImeValute,tcDrzava);

        HBox hb1=new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(10);
        hb1.setPadding( new Insets(10,5,10,5));
        hb1.getChildren().addAll(cbDrzava,btnFilter,btnRemoveFIlter);

        VBox root=new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(7);
        root.getChildren().addAll(lbLista,hb1,tvCurrency,btnUzim);

        Scene scene=new Scene(root,400,500);
        super.setScene(scene);
    }
    public void insertTabela(Collection<Currency>tr){
        tvCurrency.getItems().clear();
        tvCurrency.getItems().addAll(tr);

    }
    public void insertcb(Collection<String>tr){
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
