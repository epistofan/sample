package sample;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Logic.Controller;
import sample.Logic.db_conn_control;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml_views/Main_window.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);

            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(true);

            primaryStage.show();


            System.out.println("start");
           // Controller main = new Controller();
           //db_conn_control dbc = new db_conn_control(main);

            Timeline timeline = new Timeline();

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);

    }
}
