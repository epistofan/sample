package lv.myProject.java2.fxmlViewControllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import lv.myProject.java2.businessLogic.GetData;
import lv.myProject.java2.businessLogic.Validator;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Igor on 09.08.2017.
 */
public class DbConnectionController {
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
    String statementText;
    @FXML
    private Label ConnectionStatus;
    int i;

    String dataBaseName;
    boolean dbNameIsEmpty;
    //@FXML
    //public Controller controller;

    //  public db_conn_control(Controller main) {
    //    this.controller = main;

    //}

    //Connection con=null;
    @FXML
    Connection connection;
    Statement stmt;
    GetData getData = new GetData();
    ResultSet rs;
    String result;

    //Main_window_controller controller = new Main_window_controller();

    @FXML
    void login(ActionEvent event) {

        System.out.println("login");
        login_button.setCursor(Cursor.WAIT);

        Validator validator = new Validator();
        dataBaseName=db_s_name.getText();
        dbNameIsEmpty=validator.validateDatabaseNameIsEmpty(dataBaseName);
        if (dbNameIsEmpty){
            ConnectionStatus.setText("Can not be empty");

        }else {


/////

            String user = username.getText();
            String pass = password.getText();
            String db_name = "jdbc:sqlserver://" + db_s_name.getText();

            getData.makeConnection(user, pass, db_name);
            connection = connection;
            if (connection != null) {
                ConnectionStatus.setText("Connected");

            }

        }

        }
    }




