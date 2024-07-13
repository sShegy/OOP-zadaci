package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.FileDataBase;
import mvc.model.User;
import mvc.view.SingUpStage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        if (!email.contains("@gmail.com")){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Nepravilan email!!!");
            alert.showAndWait();
            return;
        }
        String pass=stage.getTxPassoword().getText();
        //---------------------------------------------
        LocalDate date=stage.getDatePicker().getValue();
        if (date==null){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Popunite sva polja!!!");
            alert.showAndWait();
            return;
        }
        String age=getDatetoString(date);
        //---------------------------------------------
        String gender=stage.getCbgender().getSelectionModel().getSelectedItem();
        User u=new User(ime,prez,email,pass,age,gender);
        System.out.printf(u.toString());
        if (ime==null){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Popunite sva polja!!!");
            alert.showAndWait();
            return;
        } else if (prez==null) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Popunite sva polja!!!");
            alert.showAndWait();
            return;
        } else if (pass==null) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Popunite sva polja!!!");
            alert.showAndWait();
            return;
        }else if (gender==null) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Popunite sva polja!!!");
            alert.showAndWait();
            return;
        }
        if (!fileDataBase.useExist(u)){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Uspesno ste se registrovali!!!");
            alert.showAndWait();
            fileDataBase.getUserInList(u);
            singUpStage.getTxIme().clear();
            singUpStage.getTxPrez().clear();
            singUpStage.getTxEmail().clear();
            singUpStage.getTxPassoword().clear();
            singUpStage.getCbgender().getSelectionModel().select(0);
            singUpStage.getDatePicker().getEditor().clear();
            getUserInFile(u);

        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Ovaj nalog vec postoji!!!");
            alert.showAndWait();
        }



    }
    private static String getDatetoString(LocalDate l){
        return l.format(DateTimeFormatter.ofPattern("dd/M/yyyy"));
    }
    private void getUserInFile(User u) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("User.txt", true))) { // 'true' indicates append mode
            bw.write(u.toString());
            System.out.println("Uspesno je upisan!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}