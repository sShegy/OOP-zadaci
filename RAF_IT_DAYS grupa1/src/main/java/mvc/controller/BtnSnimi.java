package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.model.Kategorija;
import mvc.view.MainStage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class BtnSnimi implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BtnSnimi(MainStage mainStage) {
        this.mainStage = mainStage;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            File fr=new File("izlaz.txt");
            FileWriter fw=new FileWriter(fr);
            BufferedWriter bw=new BufferedWriter(fw);
            Collections.sort(fileDataBase.getKategorija());
            // fileDataBase.getKategorija().sort(null);
            for (Kategorija k: fileDataBase.getKategorija()){
                bw.write(k.toString());
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
