package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.model.Kategorija;
import mvc.view.MainStage;

import java.io.*;

public class BtnSacuvaj implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BtnSacuvaj(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            File fr=new File("ispis.txt");
            FileWriter fw =new FileWriter(fr);
            BufferedWriter bw=new BufferedWriter(fw);
            for (Kategorija k: fileDataBase.getKategorija()){
                bw.write(k.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
