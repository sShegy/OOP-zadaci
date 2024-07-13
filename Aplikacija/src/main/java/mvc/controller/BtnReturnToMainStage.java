package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.view.LoginStage;
import mvc.view.SingUpStage;

public class BtnReturnToMainStage implements EventHandler<ActionEvent> {
    private SingUpStage singUpStage;


    public BtnReturnToMainStage(SingUpStage singUpStage) {
        this.singUpStage = singUpStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        LoginStage loginStage = LoginStage.getInstance();
        SingUpStage.getInstance().close();
        loginStage.show();

    }
}
