package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;
import mvc.controller.BtnBack;
import mvc.controller.BtnBet;
import mvc.controller.BtnIgraj;

public class RockPaperScissors extends Stage {
    private static RockPaperScissors instance;

    private Button btnBet = new Button("Bet");

    private Button btnIgraj1 = new Button("Igraj");
    private ImageView imageView1 = new ImageView();
    private ComboBox<String> cbIzaberi1 = new ComboBox<>();
    private Label lbVecemanje = new Label();

    private Button btnIgraj2 = new Button("Igraj");
    private ImageView imageView2 = new ImageView();
    private ComboBox<String> cbIzaberi2 = new ComboBox<>();

    private Button btnBack = new Button("Back");

    private RockPaperScissors() {
        init();
        ucitajSliku1();
        ucitajSliku2();
    }

    private void ucitajSliku1() {
        try {
            String imagePath = "file:E:\\OOP-zadaci\\Aplikacija\\images\\Rock.png";
            Image image1 = new Image(imagePath);
            imageView1.setImage(image1);
            imageView1.setFitWidth(100);
            imageView1.setFitHeight(100);
            imageView1.setPreserveRatio(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ucitajSliku2() {
        try {
            String imagePath = "file:E:\\OOP-zadaci\\Aplikacija\\images\\Paper.png";
            Image image2 = new Image(imagePath);
            imageView2.setImage(image2);
            imageView2.setFitWidth(100);
            imageView2.setFitHeight(100);
            imageView2.setPreserveRatio(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RockPaperScissors getInstance() {
        if (instance == null) {
            instance = new RockPaperScissors();
        }
        return instance;
    }

    private void init() {
        btnBet.setOnAction(new BtnBet(this));
        btnBack.setOnAction(new BtnBack(this));

        // Style Buttons
        styleButton(btnBet, "#FF6F61", "#FFFFFF");
        styleButton(btnIgraj1, "#4CAF50", "#FFFFFF");
        styleButton(btnIgraj2, "#4CAF50", "#FFFFFF");
        styleButton(btnBack, "#FF6F61", "#FFFFFF");

        // Style Label
        lbVecemanje.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        lbVecemanje.setTextFill(Color.DARKSLATEBLUE);
        lbVecemanje.setEffect(new DropShadow(5, Color.GRAY));

        // Style ComboBox
        styleComboBox(cbIzaberi1);
        styleComboBox(cbIzaberi2);

        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.TOP_RIGHT);
        hb1.setPadding(new Insets(2));
        hb1.getChildren().addAll(btnBack);

        VBox vb1 = new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(5);
        cbIzaberi1.getItems().addAll("Rock", "Paper", "Scissors");
        cbIzaberi1.getSelectionModel().selectFirst();
        btnIgraj1.setOnAction(new BtnIgraj(this, 1));
        vb1.getChildren().addAll(cbIzaberi1, imageView1, btnIgraj1);

        VBox vb2 = new VBox();
        vb2.setAlignment(Pos.CENTER);
        vb2.setSpacing(5);
        cbIzaberi2.getItems().addAll("Rock", "Paper", "Scissors");
        cbIzaberi2.getSelectionModel().select(1);
        btnIgraj2.setOnAction(new BtnIgraj(this, 2));
        vb2.getChildren().addAll(cbIzaberi2, imageView2, btnIgraj2);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(100);
        hbox.getChildren().addAll(vb1, lbVecemanje, vb2, btnBet);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(100);
        root.getChildren().addAll(hb1, hbox);

        // Set background color
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(root, 1000, 600);
        this.setScene(scene);
    }

    private void styleButton(Button button, String bgColor, String textColor) {
        button.setStyle("-fx-font-size: 16px; -fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor + ";");
        button.setEffect(new DropShadow(5, Color.GRAY));
    }

    private void styleComboBox(ComboBox<String> comboBox) {
        comboBox.setStyle("-fx-font-size: 14px;");
        comboBox.setPrefWidth(150);
    }

    public ComboBox<String> getCbIzaberi(int player) {
        return player == 1 ? cbIzaberi1 : cbIzaberi2;
    }

    public ImageView getImageView1() {
        return imageView1;
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public void setImage(int player, Image image) {
        if (player == 1) {
            imageView1.setImage(image);
        } else {
            imageView2.setImage(image);
        }
    }

    public ComboBox<String> getCbIzaberi1() {
        return cbIzaberi1;
    }

    public ComboBox<String> getCbIzaberi2() {
        return cbIzaberi2;
    }

    public Label getLbVecemanje() {
        return lbVecemanje;
    }
}
