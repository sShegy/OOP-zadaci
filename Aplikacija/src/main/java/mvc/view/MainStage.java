package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.controller.BtnSing;

public class MainStage extends Stage {
        private static MainStage instance;

        private Label lbUsername=new Label("Username");
        private TextField txUser=new TextField();

        private Label lbPassword=new Label("Password");
        private PasswordField psPassword=new PasswordField();

        private Button btnLogin=new Button("Login in");
        private Button btnSing =new Button("Sing up");

        private MainStage(){
                init();
        }
        public static MainStage getInstance(){
                if (instance==null){
                        instance=new MainStage();
                }
                return instance;
        }

        private void init(){
                btnSing.setOnAction(new BtnSing(this));

                GridPane gridPane=new GridPane();
                gridPane.addColumn(0,lbUsername,txUser);
                gridPane.addColumn(1,lbPassword,psPassword);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setPadding(new Insets(30,20,30,20));

                VBox root=new VBox();
                root.setAlignment(Pos.CENTER);
                root.setSpacing(10);
                root.getChildren().addAll(gridPane,btnLogin,btnSing);

                Scene scene=new Scene(root,400,500);
                super.setScene(scene);





        }




}
