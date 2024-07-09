package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.FileDataBase;
import mvc.model.Predavac;
import mvc.view.MainStage;

import java.security.Principal;
import java.security.spec.ECField;

import static javafx.scene.control.Alert.*;

public class BtnPromeniStatus implements EventHandler<ActionEvent> {

    private MainStage mainStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BtnPromeniStatus(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String status=mainStage.getCbStatus().getSelectionModel().getSelectedItem().toString();
        Predavac statustv=mainStage.getTvPredavaci().getSelectionModel().getSelectedItem();

        statustv.setStatus(status);
        mainStage.getCbStatus().getSelectionModel().select(2);
        String s= "NA CEKANJU";
        mainStage.insertPredavac(fileDataBase.getPredavacStatus(s));
        mainStage.getTvPredavaci().refresh();


    }
}
