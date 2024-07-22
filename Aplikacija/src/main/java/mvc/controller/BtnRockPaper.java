package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.view.Meni;

import mvc.view.RockPaperScissors;



public class BtnRockPaper implements EventHandler<ActionEvent> {
    private Meni meni;

    public BtnRockPaper(Meni meni) {
        this.meni = meni;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        RockPaperScissors rockPaperSecors=RockPaperScissors.getInstance().getInstance();
        rockPaperSecors.show();
        meni.close();
    }
}
