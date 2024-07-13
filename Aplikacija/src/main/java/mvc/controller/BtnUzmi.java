package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.CurrencyStage;
import mvc.view.CurrencyStageList;

public class BtnUzmi implements EventHandler<ActionEvent> {
    private CurrencyStageList currencyStageList;

    public BtnUzmi(CurrencyStageList currencyStageList) {
        this.currencyStageList = currencyStageList;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        CurrencyStage currencyStage=CurrencyStage.getInstance();
        FileDataBase fileDataBase=FileDataBase.getInstance();
        Double cena=currencyStageList.getTvCurrency().getSelectionModel().getSelectedItem().getCena();
        String drzava=currencyStageList.getTvCurrency().getSelectionModel().getSelectedItem().getDrzava();
        String valuta=currencyStageList.getTvCurrency().getSelectionModel().getSelectedItem().getNameCurrency();

        Double upisanaCena=Double.parseDouble(currencyStage.getTxCena().getText());

        currencyStage.getTxKrajnaCena().setText(String.valueOf(upisanaCena*cena));
        currencyStage.getLbImeValute().setText(valuta);
        currencyStage.getLbDrzava().setText(drzava);
        currencyStageList.close();
        currencyStage.show();
    }
}
