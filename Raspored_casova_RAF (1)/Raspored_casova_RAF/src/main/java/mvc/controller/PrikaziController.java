package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.MainStage;

public class PrikaziController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        String grupa = MainStage.getInstance().getGrupa();
        MainStage.getInstance().insertTermini(FileDataBase.getInstance().getTermini(grupa));
    }
}
