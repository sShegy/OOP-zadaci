package mvc.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RockPaperSecors extends Stage {
    private static RockPaperSecors instance;

    // Corrected the way to load image from resources
    private final Image image;

    private ImageView imageView;

    private RockPaperSecors() {
        // Try to load the image
        image = new Image(getClass().getResource("/images/356394493_3408702952777698_8569051923473515255_n.jpg").toExternalForm());
        imageView = new ImageView(image);
        init();
    }

    public static RockPaperSecors getInstance() {
        if (instance == null) {
            instance = new RockPaperSecors();
        }
        return instance;
    }

    private void init() {
        VBox vb1 = new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(5);
        vb1.getChildren().addAll(imageView);

        Scene scene = new Scene(vb1, 500, 600);
        super.setScene(scene);
    }
}
