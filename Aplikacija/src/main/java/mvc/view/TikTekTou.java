package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import java.util.Optional;

public class TikTekTou extends Stage {
    private static TikTekTou instance;

    private Button[][] buttons = new Button[3][3];
    private boolean playerXTurn = true;  // true = X's turn, false = O's turn
    private Label lbGameStatus = new Label("X's Turn");

    private Button btnReset = new Button("Reset");

    private TikTekTou() {
        init();
    }

    public static TikTekTou getInstance() {
        if (instance == null) {
            instance = new TikTekTou();
        }
        return instance;
    }

    private void init() {
        btnReset.setOnAction(event -> resetGame());
        btnReset.setStyle("-fx-font-size: 16px; -fx-background-color: #FF6F61; -fx-text-fill: white;");
        btnReset.setEffect(new DropShadow(5, Color.GRAY));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button("");
                button.setMinSize(100, 100);
                button.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                button.setStyle("-fx-background-color: #F4F4F4; -fx-border-color: #DDDDDD; -fx-border-width: 2px;");
                button.setEffect(new DropShadow(5, Color.GRAY));
                buttons[i][j] = button;
                gridPane.add(button, j, i);

                int finalI = i;
                int finalJ = j;
                button.setOnAction(event -> handleButtonClick(finalI, finalJ));
            }
        }

        lbGameStatus.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        lbGameStatus.setTextFill(Color.DARKSLATEBLUE);
        lbGameStatus.setEffect(new DropShadow(3, Color.GRAY));

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(lbGameStatus, gridPane, btnReset);
        vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(vbox, 400, 500);
        this.setScene(scene);
        this.setTitle("TikTekTou");
    }

    private void handleButtonClick(int i, int j) {
        if (buttons[i][j].getText().equals("")) {
            if (playerXTurn) {
                buttons[i][j].setText("X");
                lbGameStatus.setText("O's Turn");
            } else {
                buttons[i][j].setText("O");
                lbGameStatus.setText("X's Turn");
            }
            playerXTurn = !playerXTurn;

            checkGameState();
        }
    }

    private void checkGameState() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().equals("")) {
                highlightWinningCombination(i, 0, i, 1, i, 2);
                endGame(buttons[i][0].getText() + " wins!");
                return;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (buttons[0][j].getText().equals(buttons[1][j].getText()) &&
                    buttons[1][j].getText().equals(buttons[2][j].getText()) &&
                    !buttons[0][j].getText().equals("")) {
                highlightWinningCombination(0, j, 1, j, 2, j);
                endGame(buttons[0][j].getText() + " wins!");
                return;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().equals("")) {
            highlightWinningCombination(0, 0, 1, 1, 2, 2);
            endGame(buttons[0][0].getText() + " wins!");
            return;
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().equals("")) {
            highlightWinningCombination(0, 2, 1, 1, 2, 0);
            endGame(buttons[0][2].getText() + " wins!");
            return;
        }

        // Check for draw
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            endGame("It's a draw!");
        }
    }

    private void highlightWinningCombination(int r1, int c1, int r2, int c2, int r3, int c3) {
        buttons[r1][c1].setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen;");
        buttons[r2][c2].setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen;");
        buttons[r3][c3].setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen;");
    }

    private void endGame(String message) {
        lbGameStatus.setText(message);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(true);
            }
        }
        showRestartPrompt(message);
    }

    private void showRestartPrompt(String message) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message + "\nWould you like to play again?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            resetGame();
        } else {
            this.close();
            Meni meni=Meni.getInstance();
            meni.show();
        }
    }

    public void resetGame() {
        playerXTurn = true;
        lbGameStatus.setText("X's Turn");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setDisable(false);
                buttons[i][j].setStyle("-fx-background-color: #F4F4F4; -fx-border-color: #DDDDDD; -fx-border-width: 2px;");
            }
        }
    }
}
