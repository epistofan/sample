package sample.Logic;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;

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
    public Label conn_status;
    @FXML
    private Button refresh;

    String ea;
    int i;

  //@FXML
  //public Controller controller;

  //  public db_conn_control(Controller main) {
   //    this.controller = main;

   //}

    Connection con=null;

    Statement stmt;

    ResultSet rs;
    String result;
    Main_window_controller controller = new Main_window_controller();
    @FXML
    void exit() {



    }
   // @FXML
    //public String govneco(){
    //  controller.statement();

     //   System.out.println("ABC");
     //   ea="pizdauska";
       // return ea;
    //}
    @FXML
    String login(ActionEvent event) {

        System.out.println("login");
        login_button.setCursor(Cursor.WAIT);
       //controller.test1.setText("pizdauskas");

        // conn c = new conn();
        String user = username.getText();
        String pass = password.getText();
        if (db_s_name.getText().trim().isEmpty()) {
            System.out.println("nizja");

            System.out.println("gavs1");

            Stage window = new Stage();
            window.initStyle(StageStyle.UNDECORATED);
            window.initModality(Modality.APPLICATION_MODAL);
            //


            window.setX(((((Button) event.getSource()).getScene().getWindow()).getX()) + 400);
            window.setY(((((Button) event.getSource()).getScene().getWindow()).getY()) + 70);

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


            System.out.println("gavs2");
        } else {
            String db_name = "jdbc:sqlserver://" + db_s_name.getText();
            conn c = new conn();
            this.conn1(user, pass, db_name);


        }


        return result;
    }

   // @FXML
   // public void init(Controller mainController) {

           // main = mainController;
    //}

    public void conn1(String user, String pass, String db_name) {


        // Create a variable for the connection string.
        // String connectionUrl = "jdbc:sqlserver://IGORSWNOTE\\sqlexpress";
        // String user = "sa";
        // String pass = "Admin18";
        // Declare the JDBC objects.
        //Connection con = null;
       // Statement stmt = null;
        //ResultSet rs = null;

        try {


            // Establish the connection.
            System.out.println("before conn");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(db_name, user, pass);

            System.out.println("after conn");
//this.statement();
            // Create and execute an SQL statement that returns some data.
            //  String SQL = "SELECT TOP 10 * FROM Person.Contact";
            //  stmt = con.createStatement();
            //  rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            // while (rs.next()) {
            //     System.out.println(rs.getString(4) + " " + rs.getString(6));
            // }
            //String SQL = "SELECT TOP 10 * FROM Person.Contact";
            // stmt = con.createStatement();
            // rs = stmt.executeQuery(SQL);
            // Iterate through the data in the result set and display it.
            // while (rs.next()) {
            // System.out.println(rs.getString(4) + " " + rs.getString(6));
            // }
            this.statement();
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();

            System.out.println("cant connect, please check");
           //controller.test1.setText("govneco");


        } finally {
            if (rs != null) try {
               // rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                //stmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                // get a handle to the stage
                Stage stage = (Stage) b_exit.getScene().getWindow();
                // do what you have to do
                stage.close();
                // con.close();

            } catch (Exception e) {
            }
        }
    }

   /* public Connection getCon() {
        return con;

    }*/


    public void statement() throws Exception {
       // Statement stmt;
        //ResultSet rs;
        System.out.println("brrrrrrrrrrrrrrrrr");
        // Create and execute an SQL statement that returns some data.
        try {
            String SQL = "SELECT TOP 10 * FROM [test].[dbo].[table]";
            stmt = con.createStatement();
            System.out.println("brrrrrrrrrrrrrrrr23333322222222r");
            rs = stmt.executeQuery(SQL);
            System.out.println("brrrrrrrrrrrrrrrr222222222r");
            // Iterate through the data in the result set and display it.



            while (rs.next()){
                       String test = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                       String num = rs.getString(String.valueOf("numurs"));

               controller.list.add(new Person(test, lastname, num));

                i++;

                System.out.println(test+" "+num);

            }
        System.out.println(i);
           // controller.moveLabel.setText(String.valueOf(i));








        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("govno");
        }

    }
    /*@FXML
    public void injectController(Controller controller){
        System.out.println("inject");
        this.main=controller;
    }
    */
}