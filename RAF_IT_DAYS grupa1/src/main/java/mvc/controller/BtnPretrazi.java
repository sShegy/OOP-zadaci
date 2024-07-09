package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.MainStage;

public class BtnPretrazi implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();



    public BtnPretrazi(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String status=mainStage.getCbStatus().getSelectionModel().getSelectedItem().toString();
        mainStage.insertPredavac(fileDataBase.getPredavacStatus(status));
        mainStage.getTvPredavaci().refresh();

    }
}
