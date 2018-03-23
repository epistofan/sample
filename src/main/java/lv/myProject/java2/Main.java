package lv.myProject.java2;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        //ApplicationContext applicationContext
            //    = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        SpringFxmlLoader loader = new SpringFxmlLoader();


        try {
           // Class.forName("com.mysql.jdbc.Driver").newInstance();

            Parent root = loader.load(getClass().getResource("/fxmlViews/MainWindow.fxml"));
           // Parent root = FXMLLoader.load(getClass().getResource("/fxmlViews/MainWindow.fxml"));
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
