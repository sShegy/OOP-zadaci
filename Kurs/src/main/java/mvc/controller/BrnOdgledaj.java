package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.FileDataBase;
import mvc.model.Kategorija;
import mvc.view.MainStage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BrnOdgledaj implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BrnOdgledaj(MainStage mainStage) {
        this.mainStage = mainStage;
    }
    private static String getSati(LocalDateTime time){
        return time.getHour()+":"+time.getMinute();
    }
    private static String getDatum(LocalDateTime time){
        return time.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }



    @Override
    public void handle(ActionEvent actionEvent) {
        //String cena, String kategorija, String naziv, String trajanje
        String cena=mainStage.getLvOdKurseva().getSelectionModel().getSelectedItem().getNaziv();
        String kategorija=mainStage.getLvOdKurseva().getSelectionModel().getSelectedItem().getKategorija();
        //----------------------------------------------------------
        Integer pocetakSt=mainStage.getCbSati().getSelectionModel().getSelectedItem();
        Integer pocetakMin=mainStage.getCbMinuti().getSelectionModel().getSelectedItem();
        //----------------------------------------------------------
        LocalTime localTime=LocalTime.of(pocetakSt,pocetakMin);
        //----------------------------------------------------------
        LocalDate localDate=LocalDate.now();
        //----------------------------------------------------------
        LocalDateTime start=LocalDateTime.of(localDate,localTime);
        Integer kolikosegledaMIn=Integer.parseInt(mainStage.getTxTrajanjeAktivnosti().getText());
        if (kolikosegledaMIn>120){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Sadrzi vise od 120 minuta");
            alert.showAndWait();
            mainStage.getLbStaseTrenutnogleda().setText("Uneli ste vise od 120 minuta");
            return;
        }
        LocalDateTime end=start.plusMinutes(kolikosegledaMIn);
        String krajdatum=getDatum(end);
        String krajSati=getSati(end);
        String e=mainStage.getLvOdKurseva().getSelectionModel().getSelectedItem().getNaziv();
        Kategorija k=new Kategorija(kategorija,krajdatum,krajSati,cena,localDate,localTime);
        if (!fileDataBase.Kategorijaexist(k)){
            fileDataBase.dodatiKategoriju(k);
        }else {
            mainStage.getLbStaseTrenutnogleda().setText("Vec Ste dodali ovaj : "+e);

        }
        mainStage.insertKategorije(fileDataBase.getKategorija());
        mainStage.getTvKursStaseGleda().refresh();
        mainStage.getCbMinuti().getSelectionModel().select(0);
        mainStage.getCbSati().getSelectionModel().select(0);
        mainStage.getTxTrajanjeAktivnosti().clear();
    }
}
