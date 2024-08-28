package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.view.Meni;
import mvc.view.TikTekTou;

public class BtnTikTekTou implements EventHandler<ActionEvent> {
    private TikTekTou tikTekTou=TikTekTou.getInstance();
    private Meni meni;

    public BtnTikTekTou(Meni meni) {
        this.meni = meni;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        meni.close();
        tikTekTou.show();
    }
}
