package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.CurrencyStageList;

public class BtnFilterzaCurrencyTabelu implements EventHandler<ActionEvent> {
    private CurrencyStageList currencyStageList;

    public BtnFilterzaCurrencyTabelu(CurrencyStageList currencyStageList) {
        this.currencyStageList = currencyStageList;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        FileDataBase dataBase=FileDataBase.getInstance();
        String drzava=currencyStageList.getCbDrzava().getSelectionModel().getSelectedItem().toString();
        currencyStageList.insertTabela(dataBase.getdrzavezalistu(drzava));
        currencyStageList.getTvCurrency().refresh();
    }
}
