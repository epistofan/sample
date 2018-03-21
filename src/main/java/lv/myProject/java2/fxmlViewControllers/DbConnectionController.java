package lv.myProject.java2.fxmlViewControllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import lv.myProject.java2.businessLogic.DatabaseSource;
import lv.myProject.java2.businessLogic.GetData;
import lv.myProject.java2.businessLogic.PersonDatabase;
import lv.myProject.java2.businessLogic.Validator;


import java.sql.*;

/**
 * Created by Igor on 09.08.2017.
 */
public class DbConnectionController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login_button;
    @FXML
    private TextField db_s_name;
    @FXML
    private Label ConnectionStatus;


    String dataBaseName;
    boolean dbNameIsEmpty;
    //DatabaseSource databaseSource;

    DatabaseSource databaseSource = new DatabaseSource();
    PersonDatabase personDatabase = new PersonDatabase(databaseSource);

    @FXML
    void login() throws SQLException {

        System.out.println("login");
        login_button.setCursor(Cursor.WAIT);

            Validator validator = new Validator();
            dataBaseName=db_s_name.getText();
            dbNameIsEmpty=validator.validateDatabaseNameIsEmpty(dataBaseName);

        if (dbNameIsEmpty){
            ConnectionStatus.setText("Can not be empty");
        }else {
            String user = username.getText();
            String pass = password.getText();
            String db_name = "jdbc:sqlserver://" + db_s_name.getText();


databaseSource.makeConnection(user, pass, db_name);
            personDatabase.removePerson();
        }

        }
    }




