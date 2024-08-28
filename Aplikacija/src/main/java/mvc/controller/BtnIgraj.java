package mvc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import mvc.view.RockPaperScissors;

public class BtnIgraj implements EventHandler<ActionEvent> {
    private RockPaperScissors rockPaperScissors;
    private int player;

    public BtnIgraj(RockPaperScissors rockPaperScissors, int player) {
        this.rockPaperScissors = rockPaperScissors;
        this.player = player;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String r = rockPaperScissors.getCbIzaberi(player).getSelectionModel().getSelectedItem();

        if (r.equals("Rock")) {
            rockPaperScissors.setImage(player, new Image("file:E:\\OOP-zadaci\\Aplikacija\\images\\Rock.png"));
        } else if (r.equals("Paper")) {
            rockPaperScissors.setImage(player, new Image("file:E:\\OOP-zadaci\\Aplikacija\\images\\Paper.png"));
        } else {
            rockPaperScissors.setImage(player, new Image("file:E:\\OOP-zadaci\\Aplikacija\\images\\Scissors.png"));
        }
    }
}
