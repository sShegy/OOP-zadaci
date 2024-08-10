package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import mvc.view.RockPaperScissors;

public class BtnBet implements EventHandler<ActionEvent> {
    private RockPaperScissors rockPaperScissors;

    public BtnBet(RockPaperScissors rockPaperScissors) {
        this.rockPaperScissors = rockPaperScissors;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String player1Choice = rockPaperScissors.getCbIzaberi1().getSelectionModel().getSelectedItem();
        String player2Choice = rockPaperScissors.getCbIzaberi2().getSelectionModel().getSelectedItem();
        ImageView imageView1 = rockPaperScissors.getImageView1();
        ImageView imageView2 = rockPaperScissors.getImageView2();
        String result;


        boolean player1ImageMatch = player1Choice.equals(getChoiceFromImageView(imageView1));
        boolean player2ImageMatch = player2Choice.equals(getChoiceFromImageView(imageView2));

        if (!player1ImageMatch || !player2ImageMatch) {
            result = "Image and choice mismatch! Please make sure the images match your choices.";
        } else if (player1Choice.equals(player2Choice)) {
            result = "It's a tie!";
            RockPaperScissors.getInstance().getLbVecemanje().setText("=");
        } else if ((player1Choice.equals("Rock") && player2Choice.equals("Scissors")) ||
                (player1Choice.equals("Paper") && player2Choice.equals("Rock")) ||
                (player1Choice.equals("Scissors") && player2Choice.equals("Paper"))) {
            result = "Player 1 wins!";
            RockPaperScissors.getInstance().getLbVecemanje().setText(">");
        } else {
            result = "Player 2 wins!";
            RockPaperScissors.getInstance().getLbVecemanje().setText("<");
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Result");
        alert.setHeaderText(null);
        alert.setContentText(result);
        alert.showAndWait();
    }

    private String getChoiceFromImageView(ImageView imageView) {
        String imageUrl = imageView.getImage().getUrl();
        if (imageUrl.contains("Rock")) {
            return "Rock";
        } else if (imageUrl.contains("Paper")) {
            return "Paper";
        } else if (imageUrl.contains("Scissors")) {
            return "Scissors";
        }
        return "";
    }
}
