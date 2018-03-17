package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("fxml_views/MainWindow.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);

            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(true);
           // primaryStage.setMaximized(true);

            primaryStage.show();

            System.out.println("starting...");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);

    }
}
