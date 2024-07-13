package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.MainStage;
import mvc.view.SingUpStage;

public class BtnSing implements EventHandler<ActionEvent> {
    private SingUpStage stage=SingUpStage.getInstance();
    private MainStage mainStage;

    public BtnSing(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
         FileDataBase f=FileDataBase.getInstance();
        SingUpStage singUpStage=SingUpStage.getInstance();

        mainStage.close();
        singUpStage.show();

    }
}
