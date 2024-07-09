package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.model.Kategorija;
import mvc.model.Predavac;
import mvc.model.Teme;
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
        String kompanija=mainStage.getTvPredavaci().getSelectionModel().getSelectedItem().getKompanija();
        Kategorija k=new Kategorija(naziv,oblast,predavac,kompanija);
        fileDataBase.getKategorijalv(k);
        //-----------------------------------------------------
        Predavac p=mainStage.getTvPredavaci().getSelectionModel().getSelectedItem();
        Teme t=mainStage.getLvTeme().getSelectionModel().getSelectedItem();
        p.setStatus("RASPOREDJEN");
        fileDataBase.removerTema(t);
        //-----------------------------------------------------
        mainStage.insertKategorija(fileDataBase.getKategorija());
        mainStage.insertPredavac(fileDataBase.getPredavac());
        mainStage.insertTeme(fileDataBase.getTeme());
        mainStage.getTvKategorija().refresh();
        mainStage.getTvPredavaci().refresh();
        mainStage.getLvTeme().refresh();


    }
}
