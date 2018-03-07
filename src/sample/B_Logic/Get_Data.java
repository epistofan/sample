package sample.B_Logic;

import javafx.stage.Stage;
import sample.Person;

import java.sql.DriverManager;

public class Get_Data {

        public void makeConnection(String user, String pass, String db_name) {


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
            controller.connection=con;
            System.out.println("after conn");
            System.out.println(controller.connection);
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
public void getData(){

    System.out.println("brrrrrrrrrrrrrrrrr");
    // Create and execute an SQL statement that returns some data.
    try {
        String SQL = "SELECT TOP 10 * FROM [test].[dbo].[table]";
        System.out.println(connection);
        stmt = connection.createStatement();
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

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("govno");
    }
}






}
