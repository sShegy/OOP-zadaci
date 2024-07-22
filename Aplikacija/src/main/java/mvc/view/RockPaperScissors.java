package mvc.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.BtnIgraj;

public class RockPaperScissors extends Stage {
    private static RockPaperScissors instance;


    private Button btnIgraj1 = new Button("Igraj");
    private ImageView imageView1 = new ImageView();
    private ComboBox<String> cbIzaberi1 = new ComboBox<>();


    private Button btnIgraj2 = new Button("Igraj");
    private ImageView imageView2 = new ImageView();
    private ComboBox<String> cbIzaberi2 = new ComboBox<>();

    private RockPaperScissors() {
        init();
        ucitajSliku1();
        ucitajSliku2();
    }

    private void ucitajSliku1() {
        try {
            String imagePath = "file:/E:/OOP-zadaci/Aplikacija/images/Screenshot_1.png";
            System.out.println("Loading image for player 1 from: " + imagePath);
            Image image1 = new Image(imagePath);
            imageView1.setImage(image1);

            imageView1.setFitWidth(100);
            imageView1.setFitHeight(100);
            imageView1.setPreserveRatio(true);

            if (image1.isError()) {
                System.err.println("Error loading image for player 1: " + image1.getException().getMessage());
            } else {
                System.out.println("Image for player 1 loaded successfully from path: " + imagePath);
            }
        } catch (Exception e) {
            System.err.println("Exception loading image for player 1: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void ucitajSliku2() {
        try {
            String imagePath = "file:/E:/OOP-zadaci/Aplikacija/images/Screenshot_2.png";
            System.out.println("Loading image for player 2 from: " + imagePath);
            Image image2 = new Image(imagePath);
            imageView2.setImage(image2);

            imageView2.setFitWidth(100);
            imageView2.setFitHeight(100);
            imageView2.setPreserveRatio(true);

            if (image2.isError()) {
                System.err.println("Error loading image for player 2: " + image2.getException().getMessage());
            } else {
                System.out.println("Image for player 2 loaded successfully from path: " + imagePath);
            }
        } catch (Exception e) {
            System.err.println("Exception loading image for player 2: " + e.getMessage());
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
        cbIzaberi2.getSelectionModel().selectFirst();

        btnIgraj2.setOnAction(new BtnIgraj(this, 2));

        vb2.getChildren().addAll(cbIzaberi2, imageView2, btnIgraj2);


        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(20);
        hbox.getChildren().addAll(vb1, vb2);

        Scene scene = new Scene(hbox, 1000, 600);
        this.setScene(scene);
    }

    public ComboBox<String> getCbIzaberi(int player) {
        return player == 1 ? cbIzaberi1 : cbIzaberi2;
    }

    public void setImage(int player, Image image) {
        if (player == 1) {
            imageView1.setImage(image);
        } else {
            imageView2.setImage(image);
        }
    }
}
