package mvc;

import javafx.application.Application;
import javafx.stage.Stage;
import mvc.model.FileDataBase;
import mvc.view.MainStage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FileDataBase f=FileDataBase.getInstance();
        MainStage mainStage=MainStage.getInstance();
        mainStage.insertPredavac(f.getPredavac());
        mainStage.insertTeme(f.getTeme());
        mainStage.show();
    }
}
