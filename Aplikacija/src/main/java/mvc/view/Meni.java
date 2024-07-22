package mvc.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import mvc.controller.BtnOpenCurrency;
import mvc.controller.BtnRockPaper;

public class Meni extends Stage {
    private static Meni instance;

    private Button btnCurrency=new Button("Currency");
    private Button btnRockPaper=new Button("RockPaperScissors");

    private Meni() {
        init();

    }



    public static Meni getInstance(){
        if (instance==null){
            instance=new Meni();
        }
        return instance;
    }
    private void init(){

        btnCurrency.setOnAction(new BtnOpenCurrency(this));
        btnRockPaper.setOnAction(new BtnRockPaper(this));

        HBox hb1=new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(20);
        hb1.getChildren().addAll(btnRockPaper,btnCurrency);

        Scene scene=new Scene(hb1,500,600);
        super.setScene(scene);
    }
}
