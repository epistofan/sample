package sample.Logic;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Connect_to_db_launch {
   // @FXML
    boolean conn() {

    System.out.println("conn");

        try {
            Parent root = FXMLLoader.load(db_conn_control.class.getResource("../fxml_views/db_conn.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_views/db_conn.fxml"));
        //Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root, 500, 300);

      //      FXMLLoader fxmlLoader = new FXMLLoader();
     //   db_conn_control controller = fxmlLoader.getController();

        //controller.init(Main_window_controller);


        stage.setScene(scene);

        stage.show();


    } catch (Exception e) {
        e.printStackTrace();

    }

        return true;
    }
}
