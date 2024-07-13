package mvc;

import javafx.application.Application;
import javafx.stage.Stage;
import mvc.view.LoginStage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        LoginStage loginStage = LoginStage.getInstance();
        loginStage.show();
    }
}
