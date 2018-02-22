package sample;


import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 * Created by Igor on 07.08.2017.
 */
public class conn {
    @FXML
    public Controller main;




        void conn1 (String user, String pass, String db_name){


            // Create a variable for the connection string.
            // String connectionUrl = "jdbc:sqlserver://IGORSWNOTE\\sqlexpress";
            // String user = "sa";
            // String pass = "Admin18";
            // Declare the JDBC objects.
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {


                // Establish the connection.
                System.out.println("before conn");

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                con = DriverManager.getConnection(db_name, user, pass);

                System.out.println("after conn");

                // Create and execute an SQL statement that returns some data.
                //  String SQL = "SELECT TOP 10 * FROM Person.Contact";
                //  stmt = con.createStatement();
                //  rs = stmt.executeQuery(SQL);

                // Iterate through the data in the result set and display it.
                // while (rs.next()) {
                //     System.out.println(rs.getString(4) + " " + rs.getString(6));
                // }
            }

            // Handle any errors that may have occurred.
            catch (Exception e) {
                //e.printStackTrace();

                System.out.println("cant connect, please check");



            } finally {
                if (rs != null) try {
                    rs.close();
                } catch (Exception e) {
                }
                if (stmt != null) try {
                    stmt.close();
                } catch (Exception e) {
                }
                if (con != null) try {

                    con.close();

                } catch (Exception e) {
                }
            }

        }
        @FXML
    public void init(Controller mainController) {
        main = mainController;
    }
    }


