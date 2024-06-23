package mvc;

import javafx.application.Application;
import javafx.stage.Stage;
import mvc.model.FileDataBase;
import mvc.view.MainStage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        System.out.println("nw");
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FileDataBase fileDataBase=FileDataBase.getInstance();
        MainStage mainStage=new MainStage();
        mainStage.insertKurs(FileDataBase.getInstance().getKursevci());
        mainStage.insertSate(fileDataBase.getSate());
        mainStage.insertMinute(fileDataBase.getMinute());
        mainStage.show();
        System.out.println("ok");
    }
}
