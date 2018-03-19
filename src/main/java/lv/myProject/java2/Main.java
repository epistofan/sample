package lv.myProject.java2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
           // Class.forName("com.mysql.jdbc.Driver").newInstance();

            Parent root = FXMLLoader.load(getClass().getResource("/fxmlViews/MainWindow.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(true);
           // primaryStage.setMaximized(true);
            primaryStage.show();
            System.out.println("starting...");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);

    }
}
