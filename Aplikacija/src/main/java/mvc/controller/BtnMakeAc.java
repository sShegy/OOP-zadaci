package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.FileDataBase;
import mvc.model.User;
import mvc.view.SingUpStage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BtnMakeAc implements EventHandler<ActionEvent> {
    private SingUpStage singUpStage;

    public BtnMakeAc(SingUpStage singUpStage) {
        this.singUpStage = singUpStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SingUpStage stage=SingUpStage.getInstance();
        FileDataBase fileDataBase=FileDataBase.getInstance();
        //Milan;Segan;milan@gmail.com;123;20;Male
        String ime=stage.getTxIme().getText();
        String prez=stage.getTxPrez().getText();
        String email=stage.getTxEmail().getText();
        String pass=stage.getTxPassoword().getText();
        //---------------------------------------------
        LocalDate date=stage.getDatePicker().getValue();
        String age=getDatetoString(date);
        //---------------------------------------------
        String gender=stage.getCbgender().getSelectionModel().getSelectedItem();
        User u=new User(ime,prez,email,pass,age,gender);
        System.out.printf(u.toString());
        if (!fileDataBase.Useexiat(u)){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Uspesno ste se registrovali!!!");
            alert.showAndWait();
            fileDataBase.getUserInList(u);
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Ovaj nalog vec postoji!!!");
            alert.showAndWait();
            return;
        }

    }
    private static String getDatetoString(LocalDate l){
        return l.format(DateTimeFormatter.ofPattern("dd/M/yyyy"));
    }
}
