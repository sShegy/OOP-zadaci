package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.view.Meni;
import mvc.view.RockPaperScissors;

public class BtnBack implements EventHandler<ActionEvent> {
    private RockPaperScissors rockPaperScissors;

    public BtnBack(RockPaperScissors rockPaperScissors) {
        this.rockPaperScissors = rockPaperScissors;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        rockPaperScissors.close();
        Meni meni=Meni.getInstance();
        meni.show();
    }
}
