package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
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
        CurrencyStage currencyStage = CurrencyStage.getInstance();
        FileDataBase fileDataBase = FileDataBase.getInstance();


        if (currencyStageList.getTvCurrency().getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Molimo odaberite valutu iz tabele!");
            alert.show();
            return;
        }

        Double cena = currencyStageList.getTvCurrency().getSelectionModel().getSelectedItem().getCena();
        String drzava = currencyStageList.getTvCurrency().getSelectionModel().getSelectedItem().getDrzava();
        String valuta = currencyStageList.getTvCurrency().getSelectionModel().getSelectedItem().getNameCurrency();


        Double upisanaCena;
        try {
            upisanaCena = Double.parseDouble(currencyStage.getTxCena().getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Uneta vrednost mora biti broj!");
            alert.show();
            return;
        }


        if (upisanaCena == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Uneta vrednost ne sme biti nula!");
            alert.show();
            return;
        }


        currencyStage.getTxKrajnaCena().setText(String.valueOf(upisanaCena * cena));
        currencyStage.getLbImeValute().setText(valuta);
        currencyStage.getLbDrzava().setText(drzava);


        currencyStageList.close();
        currencyStage.show();
    }
}
