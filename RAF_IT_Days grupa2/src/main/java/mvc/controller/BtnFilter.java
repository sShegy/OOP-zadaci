package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.MainStage;

public class BtnFilter implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BtnFilter(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String oblast=mainStage.getCbOblast().getSelectionModel().getSelectedItem().toString();
        if (oblast=="Sve oblasti"){
            mainStage.insertLvTeme(fileDataBase.getTeme());
            mainStage.insertLvPredavac(fileDataBase.getPredavac());
            mainStage.getLvPredavac().refresh();
            mainStage.getLvTeme().refresh();
        }else {
            mainStage.insertLvPredavac(fileDataBase.getPredmetFilter(oblast));
            mainStage.insertLvTeme(fileDataBase.getTemeFilter(oblast));
            mainStage.getLvPredavac().refresh();
            mainStage.getLvTeme().refresh();
        }


    }
}
