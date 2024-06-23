package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.model.Kategorija;
import mvc.view.MainStage;

public class BrnOdgledaj implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BrnOdgledaj(MainStage mainStage) {
        this.mainStage = mainStage;
    }



    @Override
    public void handle(ActionEvent actionEvent) {
        //String cena, String kategorija, String naziv, String trajanje
        String cena=mainStage.getLvOdKurseva().getSelectionModel().getSelectedItem().getNaziv();
        String kategorija=mainStage.getLvOdKurseva().getSelectionModel().getSelectedItem().getKategorija();
        Kategorija k=new Kategorija(kategorija,cena);
        fileDataBase.getDadada().add(k);
        mainStage.insertKategorije(fileDataBase.getKategorija());
        mainStage.getLvOdKurseva().refresh();
    }
}
