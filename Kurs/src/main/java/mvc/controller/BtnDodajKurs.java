package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.model.Kurs;
import mvc.view.MainStage;

public class BtnDodajKurs implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase= FileDataBase.getInstance();
    private int broj=1000;

    public BtnDodajKurs(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Kurs k=mainStage.getLvKursevi().getSelectionModel().getSelectedItem();
        String e=mainStage.getLvKursevi().getSelectionModel().getSelectedItem().getNaziv();

        if (!fileDataBase.Kursexist(k)){

            fileDataBase.dodatikurs(k);
        }else {
            mainStage.getLbStaseTrenutnogleda().setText("Vec ste izabrati taj film"+e);
        }

        mainStage.insertKurslista(fileDataBase.getOdabranikurs());
        mainStage.getLvKursevi().refresh();
    }
}
