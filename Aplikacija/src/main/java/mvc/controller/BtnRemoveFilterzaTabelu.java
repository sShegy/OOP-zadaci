package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.model.FileDataBase;
import mvc.view.CurrencyStageList;

public class BtnRemoveFilterzaTabelu implements EventHandler<ActionEvent> {
    private CurrencyStageList currencyStageList;

    public BtnRemoveFilterzaTabelu(CurrencyStageList currencyStageList) {
        this.currencyStageList = currencyStageList;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        FileDataBase fileDataBase=FileDataBase.getInstance();
        currencyStageList.insertTabela(fileDataBase.getCurrencie());
        currencyStageList.insertcb(fileDataBase.getDrzave());
        currencyStageList.getTvCurrency().refresh();
    }
}
