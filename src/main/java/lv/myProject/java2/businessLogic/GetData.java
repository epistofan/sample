package lv.myProject.java2.businessLogic;

import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetData {
        String statementText;
        Connection connection;
    protected String user;
        String pass;
        String db_name;
        Statement statement;
        ResultSet resultSet;
        Integer i;

        public Connection makeConnection(String user, String pass, String db_name) {


            try {

            // Establish the connection.
            System.out.println("before connection");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("class");
            connection = DriverManager.getConnection(db_name, user, pass);

            System.out.println("after connection");
            System.out.println(connection);



        // Handle any errors that may have occurred.
            }catch (Exception e) {

            e.printStackTrace();
            System.out.println("can not connect, please check");
            //controller.test1.setText("govneco");

            }
            return connection;
        }

        public void getData(String statementText, Connection connection){

                System.out.println("getting data");
                // Create and execute an SQL statement that returns some data.
            try {
                    String SQL = "SELECT TOP 10 * FROM [test].[dbo].[table]";
                    System.out.println(connection);
                     statement = connection.createStatement();
                    System.out.println("statement");
                    resultSet = statement.executeQuery(SQL);
                    System.out.println("query executing");
                    // Iterate through the data in the result set and display it.



            while (resultSet.next()){
                    String test = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String num = resultSet.getString(String.valueOf("numurs"));

                   // controller.list.add(new Person(test, lastname, num));

                    i++;

                    System.out.println(test+" "+num);
            }
            System.out.println(i);

            } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("fail");
            }
        }






}
