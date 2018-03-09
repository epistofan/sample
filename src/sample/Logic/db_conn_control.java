package sample.Logic;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import sample.B_Logic.Get_Data;
import sample.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Igor on 09.08.2017.
 */
public class db_conn_control  {
    @FXML
    private Button b_exit;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login_button;
    @FXML
    private Button statementb;
    @FXML
    private TextField db_s_name;
    @FXML
    public Tooltip w;
    @FXML
    private Button refresh;


    int i;

  //@FXML
  //public Controller controller;

  //  public db_conn_control(Controller main) {
   //    this.controller = main;

   //}

    Connection con=null;
    @FXML
    Connection connection;
    Statement stmt;
    Get_Data getData = new Get_Data();
    ResultSet rs;
    String result;

    Main_window_controller controller = new Main_window_controller();
    @FXML
    void exit() {

    }

    @FXML
    String login(ActionEvent event) {

        System.out.println("login");
        login_button.setCursor(Cursor.WAIT);

        if (db_s_name.getText().trim().isEmpty()) {
            System.out.println("empty");

            Stage window = new Stage();
            window.initStyle(StageStyle.UNDECORATED);
            window.initModality(Modality.APPLICATION_MODAL);


            //popup position
            //window.setX(((((Button) event.getSource()).getScene().getWindow()).getX()) + 400);
            //window.setY(((((Button) event.getSource()).getScene().getWindow()).getY()) + 70);

            Label esj = new Label("cannot be empty");

            esj.setAlignment(Pos.CENTER);


            VBox layout = new VBox(10);
            layout.setStyle("-fx-border-color: grey;");
            layout.setAlignment(Pos.CENTER);
            layout.getChildren().addAll(esj);
            Scene scene = new Scene(layout, 200, 50);

            window.setScene(scene);
            window.show();


            scene.setOnMouseMoved(e -> window.close());


        } else {
            String user = username.getText();
            String pass = password.getText();
            String db_name = "jdbc:sqlserver://" + db_s_name.getText();

            getData.makeConnection(user, pass, db_name);


        }


        return result;
    }


    public void statement(Connection connection) throws Exception {
                getData.getData();

    }

}