package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.LoginStage;
import mvc.view.SingUpStage;

public class BtnSing implements EventHandler<ActionEvent> {
    private SingUpStage stage=SingUpStage.getInstance();
    private LoginStage loginStage;

    public BtnSing(LoginStage loginStage) {
        this.loginStage = loginStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
         FileDataBase f=FileDataBase.getInstance();
        SingUpStage singUpStage=SingUpStage.getInstance();

        loginStage.close();
        singUpStage.show();

    }
}
