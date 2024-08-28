package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import mvc.controller.BtnLogin;
import mvc.controller.BtnSing;

public class LoginStage extends Stage {
        private static LoginStage instance;

        private Label lbUsername = new Label("Username: 👇");
        private TextField txUser = new TextField();

        private Label lbPassword = new Label("Password: ⏬");
        private PasswordField psPassword = new PasswordField();

        private Button btnLogin = new Button("Log in");
        private Button btnSing = new Button("Sign up");

        private LoginStage() {
                init();
        }

        public static LoginStage getInstance() {
                if (instance == null) {
                        instance = new LoginStage();
                }
                return instance;
        }

        private void init() {
                super.setTitle("Sign up");

                // Actions for buttons
                btnSing.setOnAction(new BtnSing(this));
                btnLogin.setOnAction(new BtnLogin(this));

                txUser.setPromptText("Email...");
                psPassword.setPromptText("Password...");

                // Load and add logo
                ImageView logo = new ImageView(new Image("file:E:\\OOP-zadaci\\Aplikacija\\WhatsApp Image 2024-08-28 at 17.28.37_44620e20.jpg"));
                logo.setFitWidth(100);
                logo.setFitHeight(100);
                logo.setPreserveRatio(true);

                // GridPane setup with background color
                GridPane gridPane = new GridPane();
                gridPane.addColumn(0, lbUsername, txUser);
                gridPane.addColumn(1, lbPassword, psPassword);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setPadding(new Insets(30, 20, 30, 20));
                gridPane.setVgap(10);  // Vertical spacing between rows
                gridPane.setHgap(10);  // Horizontal spacing between columns
                gridPane.setStyle("-fx-background-color: #2E4053; -fx-background-radius: 10;");  // New background color with rounded corners

                // Styling Labels
                styleLabel(lbUsername);
                styleLabel(lbPassword);

                // Styling TextFields
                styleTextField(txUser);
                styleTextField(psPassword);

                // Styling Buttons
                styleButton(btnLogin, "#4CAF50", "#FFFFFF");
                styleButton(btnSing, "#2196F3", "#FFFFFF");

                VBox root = new VBox();
                root.setAlignment(Pos.CENTER);
                root.setSpacing(20);  // Increased spacing between elements
                root.getChildren().addAll(logo, gridPane, btnLogin, btnSing);  // Added logo to the VBox
                root.setPadding(new Insets(20));  // Add padding around the VBox

                // Create stack pane to hold everything
                StackPane stackPane = new StackPane();
                stackPane.getChildren().addAll(root);

                Scene scene = new Scene(stackPane, 400, 500);
                super.setScene(scene);
        }

        private void styleLabel(Label label) {
                label.setFont(Font.font("Arial", FontWeight.BOLD, 16));  // Slightly larger font
                label.setTextFill(Color.WHITE);
                label.setEffect(new DropShadow(5, Color.BLACK));  // Add shadow to make text stand out
        }

        private void styleTextField(TextField textField) {
                textField.setPrefWidth(250);
                textField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5; -fx-padding: 8px; -fx-border-color: white; -fx-border-radius: 5;");
                textField.setEffect(new DropShadow(5, Color.BLACK));  // Add shadow for a 3D effect
        }

        private void styleButton(Button button, String bgColor, String textColor) {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                button.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor + "; -fx-background-radius: 10;");
                button.setPrefSize(150, 40);
                button.setEffect(new DropShadow(5, Color.BLACK));  // Add shadow to buttons
        }

        public TextField getTxUser() {
                return txUser;
        }

        public PasswordField getPsPassword() {
                return psPassword;
        }
}
