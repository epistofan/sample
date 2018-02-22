package sample;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.awt.event.ActionEvent;

public class Main extends Application {

    double xOffset = 0.0;
    double yOffset = 0.0;
    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);

            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(true);

            primaryStage.show();

            //MAKE WINDOW DRAG
/*
        root.setOnMousePressed(e -> {
                   // System.out.println("test");



                    primaryStage.getX();
                    primaryStage.getY();
                    e.getScreenX();
                    e.getScreenY();
                    xOffset=e.getScreenX()-primaryStage.getX();

                    yOffset=e.getScreenY()- primaryStage.getY();

                }


        );


        root.setOnMouseDragged(ev -> {





           primaryStage.setX(ev.getScreenX()- xOffset);
          primaryStage.setY(ev.getScreenY()- yOffset);


        });
*/
            Timeline timeline = new Timeline();

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
