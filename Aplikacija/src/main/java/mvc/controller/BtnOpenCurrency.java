package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.CurrencyStage;
import mvc.view.Meni;

public class BtnOpenCurrency implements EventHandler<ActionEvent> {
    private Meni meni;

    public BtnOpenCurrency(Meni meni) {
        this.meni = meni;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        FileDataBase fileDataBase=FileDataBase.getInstance();
        CurrencyStage currencyStage = CurrencyStage.getInstance();
        currencyStage.inserCbDrzave(fileDataBase.getDrzave());
        currencyStage.show();
        meni.close();
    }
}
