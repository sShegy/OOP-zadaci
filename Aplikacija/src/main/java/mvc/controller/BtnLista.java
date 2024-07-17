package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.Currency;
import mvc.model.FileDataBase;
import mvc.view.CurrencyStage;
import mvc.view.CurrencyStageList;

public class BtnLista implements EventHandler<ActionEvent> {
    private CurrencyStage currency;

    public BtnLista(CurrencyStage currency) {
        this.currency = currency;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        FileDataBase fileDataBase=FileDataBase.getInstance();
        CurrencyStageList currencyStageListF=CurrencyStageList.getInstance();
        String cena=currency.getTxCena().getText();

        if (cena==null){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Morate da stavite neki iznos!!");
            alert.showAndWait();
            return;
        }
        
        currencyStageListF.insertTabela(fileDataBase.getCurrencie());
        currencyStageListF.insertcb(fileDataBase.getDrzave());
        currency.close();
        currencyStageListF.show();
    }
}
