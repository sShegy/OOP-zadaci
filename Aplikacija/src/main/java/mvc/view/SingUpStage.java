package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.BtnMakeAc;
import mvc.controller.BtnReturnToMainStage;

import javax.swing.plaf.SplitPaneUI;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collection;

public class SingUpStage extends Stage {
    private static SingUpStage instance;

    private Label lbIme=new Label("Ime: ");
    private Label lbPrez=new Label("Prezime: ");
    private Label lbEmail=new Label("Email: ");
    private Label lbPassword=new Label("Password: ");


    private ChoiceBox<String>cbgender=new ChoiceBox<>();
    private DatePicker datePicker=new DatePicker();


    private TextField txIme=new TextField();
    private TextField txPrez=new TextField();
    private TextField txEmail=new TextField();
    private TextField txPassoword=new TextField();

    private Button btnMakeAc=new Button("Make account");
    private Button btnReturn=new Button("Return to Main Stage");
    private SingUpStage() {
        init();
    }

    public static SingUpStage getInstance(){
        if (instance==null){
            instance=new SingUpStage();
        }
        return instance;
    }


    private void init() {
        super.setTitle("Sing up");

        btnReturn.setOnAction(new BtnReturnToMainStage(this));
        btnMakeAc.setOnAction(new BtnMakeAc(this));

        cbgender.getItems().addAll("Male","Female");
        cbgender.getSelectionModel().select(0);

        GridPane gp=new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(10,5,10,5));
        gp.add(lbIme,0,0);
        gp.add(txIme,0,1);
        gp.add(lbPrez,0,2);
        gp.add(txPrez,0,3);
        gp.add(lbEmail,0,4);
        gp.add(txEmail,0,5);
        gp.add(lbPassword,0,6);
        gp.add(txPassoword,0,7);

        HBox root=new HBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gp,datePicker,cbgender);

        VBox root1=new VBox();
        root1.setSpacing(10);
        root1.setAlignment(Pos.CENTER);
        root1.getChildren().addAll(root,btnMakeAc,btnReturn);


        Scene scene=new Scene(root1,400,500);
        super.setScene(scene);

    }

    public ChoiceBox<String> getCbgender() {
        return cbgender;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public TextField getTxIme() {
        return txIme;
    }

    public TextField getTxPrez() {
        return txPrez;
    }

    public TextField getTxEmail() {
        return txEmail;
    }

    public TextField getTxPassoword() {
        return txPassoword;
    }
}
