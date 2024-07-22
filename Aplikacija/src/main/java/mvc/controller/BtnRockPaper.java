package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.view.Meni;
import mvc.view.RockPaperSecors;

public class BtnRockPaper implements EventHandler<ActionEvent> {
    private Meni meni;

    public BtnRockPaper(Meni meni) {
        this.meni = meni;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        RockPaperSecors rockPaperSecors=RockPaperSecors.getInstance();
        rockPaperSecors.show();
        meni.close();
    }
}
