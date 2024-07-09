package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mvc.model.FileDataBase;
import mvc.model.Predavac;
import mvc.view.MainStage;

import static javafx.scene.control.Alert.AlertType;

public class BtnPromeniStatus implements EventHandler<ActionEvent> {

    private MainStage mainStage;
    private FileDataBase fileDataBase = FileDataBase.getInstance();

    public BtnPromeniStatus(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String status = mainStage.getCbStatus().getSelectionModel().getSelectedItem().toString();
        Predavac selectedPredavac = mainStage.getTvPredavaci().getSelectionModel().getSelectedItem();

        if (selectedPredavac != null) {
            String currentStatus = selectedPredavac.getStatus();

            if ("NA CEKANJU".equals(currentStatus)) {
                switch (status) {
                    case "POTVRDJEN":
                    case "ODBIJEN":
                        selectedPredavac.setStatus(status);
                        break;
                    default:
                        showAlert("Nevažeći status: " + status);
                }
            } else {
                showAlert("Samo predavači sa statusom 'NA CEKANJU' mogu promeniti status.");
            }

            mainStage.getCbStatus().getSelectionModel().select(2); // Selektujte treći element (indeks 2)
            String pendingStatus = "NA CEKANJU";
            mainStage.insertPredavac(fileDataBase.getPredavacStatus(pendingStatus)); // Osvežavanje liste predavača
            mainStage.getTvPredavaci().refresh(); // Osvežavanje prikaza tabele
        } else {
            showAlert("Nijedan predavač nije selektovan.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.showAndWait();
    }
}
