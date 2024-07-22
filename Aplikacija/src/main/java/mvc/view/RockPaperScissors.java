package mvc.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RockPaperScissors extends Stage {
    private static RockPaperScissors instance;

    private Image image;
    private ImageView imageView;

    private RockPaperScissors() {
        ucitajsliku();
        init();
    }

    private void ucitajsliku() {
        try {
            // Use the correct path format
            String imagePath = "file:/E:/OOP-zadaci/Aplikacija/images/Screenshot_1.png";
            System.out.println("Loading image from: " + imagePath);
            image = new Image(imagePath);
            imageView = new ImageView(image);

            // Set the dimensions for a profile picture
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);

            if (image.isError()) {
                System.err.println("Error loading image: " + image.getException().getMessage());
            } else {
                System.out.println("Image loaded successfully from path: " + imagePath);
            }
        } catch (Exception e) {
            System.err.println("Exception loading image: " + e.getMessage());
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

        if (imageView != null) {
            vb1.getChildren().add(imageView);
        }

        // Set the scene size to fit the profile picture dimensions
        Scene scene = new Scene(vb1, 500, 600);
        super.setScene(scene);
    }
}
