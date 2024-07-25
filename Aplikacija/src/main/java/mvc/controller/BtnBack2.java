package mvc.controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.view.CurrencyStage;
import mvc.view.Meni;
import mvc.view.RockPaperScissors;

public class BtnBack2 implements EventHandler<ActionEvent> {
    private CurrencyStage currencyStage;

    public BtnBack2(CurrencyStage currencyStage) {
        this.currencyStage = currencyStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        currencyStage.close();
        Meni meni=Meni.getInstance();
        meni.show();
    }
}
