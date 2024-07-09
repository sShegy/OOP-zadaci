package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.model.Kategorija;
import mvc.view.MainStage;

import java.util.List;

public class BtnUpisiPredavaca implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BtnUpisiPredavaca(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String predavac=mainStage.getTvPredavaci().getSelectionModel().getSelectedItem().getPred();
        String naziv=mainStage.getLvTeme().getSelectionModel().getSelectedItem().getNaslov();
        List<String> oblast = mainStage.getLvTeme().getSelectionModel().getSelectedItem().getOblast();
        Kategorija k=new Kategorija(naziv,oblast,predavac);
        fileDataBase.getKategorijalv(k);
        mainStage.insertKategorija(fileDataBase.getKategorija());
        mainStage.getTvKategorija().refresh();


    }
}
