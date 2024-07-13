package mvc.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainStage extends Stage {
    private static MainStage instance;

    private Label lbCena=new Label("Cena");


    private MainStage(){
        init();
    }
    public static MainStage getInstance(){
        if (instance==null){
            instance=new MainStage();
        }
        return instance;
    }
    private void init(){
        super.setTitle("Main Stage");



        VBox vb1=new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(5);
        vb1.getChildren().addAll(lbCena);

        Scene scene=new Scene(vb1,500,600);
        super.setScene(scene);

    }

}
