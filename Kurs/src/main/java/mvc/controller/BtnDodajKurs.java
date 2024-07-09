package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.FileDataBase;
import mvc.model.Kurs;
import mvc.view.MainStage;

public class BtnDodajKurs implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase= FileDataBase.getInstance();
    private  String broje="1000";

    public BtnDodajKurs(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Kurs k=mainStage.getLvKursevi().getSelectionModel().getSelectedItem();
        String e=mainStage.getLvKursevi().getSelectionModel().getSelectedItem().getNaziv();
        String tent=mainStage.getLvKursevi().getSelectionModel().getSelectedItem().getCena();
        //$99
        String[]pares=tent.split("\\$");
        Integer cena=Integer.parseInt(pares[1]);
        Integer broj=Integer.parseInt(broje);
        mainStage.getLbRaspolozivoStaje().setText(broje);



        if (!fileDataBase.Kursexist(k)){
            if ((broj-cena)<0) {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Nemate dovoljno u kasi");
                alert.showAndWait();
                return;
            }else {
                broje=String.valueOf(broj-cena);
                mainStage.getLbRaspolozivoStaje().setText(broje);
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Imate dovoljno para na racunu, trenutno stanje: "+broje);
                alert.showAndWait();
                fileDataBase.dodatikurs(k);
            }
        }else {
            mainStage.getLbStaseTrenutnogleda().setText("Vec ste izabrali taj film"+e);
        }

        mainStage.insertKurslista(fileDataBase.getOdabranikurs());
        mainStage.getLvKursevi().refresh();
    }
}
