package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.FileDataBase;
import mvc.model.Kategorija;
import mvc.view.MainStage;

public class BtnDodaj implements EventHandler<ActionEvent> {
    private MainStage mainStage;
    private FileDataBase fileDataBase = FileDataBase.getInstance();

    public BtnDodaj(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String dan = mainStage.getCbDani().getSelectionModel().getSelectedItem();
        String predavanje = mainStage.getCbPreVez().getSelectionModel().getSelectedItem();
        Integer vreme = parseInteger(mainStage.getTxVreme().getText());
        String predavac = mainStage.getLvPredavac().getSelectionModel().getSelectedItem().toString();
        String tema = mainStage.getLvTeme().getSelectionModel().getSelectedItem().toString();
        String kategorija = mainStage.getLvPredavac().getSelectionModel().getSelectedItem().toString();

        switch (dan) {
            case "Prvi dan":
            case "Drugi dan":
            case "Treci dan":
                if (vreme >= 10 && vreme < 19) {
                    handleEventWithinDay(dan, predavanje, vreme, predavac, tema, kategorija);
                } else {
                    showAlert("Izvan satnice seminara!");
                }
                break;
            case "Cetvrti dan":
                if (vreme >= 10 && vreme < 15) {
                    handleEventWithinDay(dan, predavanje, vreme, predavac, tema, kategorija);
                } else {
                    showAlert("Izvan satnice seminara!");
                }
                break;
            default:
                showAlert("Nevalidan dan!");
                break;
        }
    }

    private void handleEventWithinDay(String dan, String predavanje, int vreme, String predavac, String tema, String kategorija) {
        if (vreme >= 13 && vreme < 14) {
            showAlert("Vreme rucka!");
        } else {
            Kategorija k = new Kategorija(dan, predavanje, predavac, tema, vreme, kategorija);
            fileDataBase.getKategorijeubazu(k);
            showAlert("Kategorija uspesno dodata!");
            mainStage.insertKategorija(fileDataBase.getKategorija());
            mainStage.getTvKategorija().refresh();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.showAndWait();
    }

    private Integer parseInteger(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            showAlert("Unesite validan broj za vreme!");
            return null;
        }
    }
}
