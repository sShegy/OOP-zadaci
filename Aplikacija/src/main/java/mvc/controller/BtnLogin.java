package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.FileDataBase;
import mvc.view.LoginStage;
import mvc.view.CurrencyStage;
import mvc.view.Meni;

public class BtnLogin implements EventHandler<ActionEvent> {
    private LoginStage loginStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BtnLogin(LoginStage loginStage) {
        this.loginStage = loginStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String email= loginStage.getTxUser().getText();
        if (!email.contains("@gmail.com")){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Pogresan unos emaila!!!");
            alert.showAndWait();
        }else {
            String password= loginStage.getPsPassword().getText();
            if (fileDataBase.userExist(email,password)){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Uspesno ste se loginali");
                alert.showAndWait();
                loginStage.close();
                Meni meni=  Meni.getInstance();
                meni.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Korisnik ne postoji, napravite nalog!");
                alert.showAndWait();
            }
        }


    }
}
