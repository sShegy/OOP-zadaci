package mvc.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mvc.controller.BtnOpenCurrency;
import mvc.controller.BtnRockPaper;
import mvc.controller.BtnTikTekTou;

public class Meni extends Stage {
    private static Meni instance;

    private Button btnCurrency = new Button("Currency");
    private Button btnRockPaper = new Button("RockPaperScissors");
    private Button btnTikTekTou = new Button("TikTekTou");

    private Meni() {
        init();
    }

    public static Meni getInstance() {
        if (instance == null) {
            instance = new Meni();
        }
        return instance;
    }

    private void init() {
        // Set actions for buttons
        btnCurrency.setOnAction(new BtnOpenCurrency(this));
        btnRockPaper.setOnAction(new BtnRockPaper(this));
        btnTikTekTou.setOnAction(new BtnTikTekTou(this));

        // Style the buttons
        styleButton(btnCurrency, "#FF6F61", "#FFFFFF");
        styleButton(btnRockPaper, "#4CAF50", "#FFFFFF");
        styleButton(btnTikTekTou, "#2196F3", "#FFFFFF");

        // Create and style HBox
        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(20);
        hb1.getChildren().addAll(btnRockPaper, btnCurrency, btnTikTekTou);

        // Create VBox to center the HBox vertically
        VBox vb1 = new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb1.getChildren().add(hb1);

        // Set background color
        vb1.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, null)));

        // Create scene
        Scene scene = new Scene(vb1, 500, 600);
        super.setScene(scene);
    }

    private void styleButton(Button button, String bgColor, String textColor) {
        button.setStyle("-fx-font-size: 18px; -fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor + ";");
        button.setEffect(new DropShadow(5, Color.GRAY));
        button.setPrefSize(150, 50); // Set preferred size for buttons
    }
}
