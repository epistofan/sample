package lv.myProject.java2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lv.myProject.java2.Configs.SpringAppConfig;
import lv.myProject.java2.fxmlViewControllers.MainWindowController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        //ApplicationContext applicationContext
            //    = new AnnotationConfigApplicationContext(SpringAppConfig.class);
       // SpringFxmlLoader loader = new SpringFxmlLoader();

        ApplicationContext applicationContext
       = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        applicationContext.getBean(MainWindowController.class);
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(applicationContext::getBean);

        try {
           // Class.forName("com.mysql.jdbc.Driver").newInstance();

            Parent root = loader.load(getClass().getResource("/fxmlViews/MainWindow.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(true);
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
