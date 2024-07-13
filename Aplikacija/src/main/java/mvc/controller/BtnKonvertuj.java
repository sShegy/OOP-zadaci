package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.CurrencyStage;

public class BtnKonvertuj implements EventHandler<ActionEvent> {
    private CurrencyStage currencyStage;
    private FileDataBase fileDataBase=FileDataBase.getInstance();

    public BtnKonvertuj(CurrencyStage currencyStage) {
        this.currencyStage = currencyStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String drzava= currencyStage.getCbDrzava().getValue();
        Double cena= Double.parseDouble(currencyStage.getTxCena().getText());

        String imeValuteDrzava= fileDataBase.getValueCurrency(drzava);

        Double krajnacena=fileDataBase.getValu(drzava);
        currencyStage.getLbDrzava().setText(drzava);
        currencyStage.getLbImeValute().setText(fileDataBase.getValueCurrency(drzava));
        currencyStage.getTxKrajnaCena().setText(String.valueOf(cena*krajnacena));
    }

}
