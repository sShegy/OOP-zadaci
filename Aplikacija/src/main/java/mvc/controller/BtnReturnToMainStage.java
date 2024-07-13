package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.view.MainStage;
import mvc.view.SingUpStage;

public class BtnReturnToMainStage implements EventHandler<ActionEvent> {
    private SingUpStage singUpStage;


    public BtnReturnToMainStage(SingUpStage singUpStage) {
        this.singUpStage = singUpStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MainStage mainStage=MainStage.getInstance();
        SingUpStage.getInstance().close();
        mainStage.show();

    }
}
