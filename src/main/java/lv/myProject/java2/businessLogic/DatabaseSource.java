package lv.myProject.java2.businessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseSource {



    Connection connection = null;
    protected String user;
    String pass;
    String db_name;
    Statement statement;
    ResultSet resultSet;



    public void makeConnection(String user, String pass, String db_name) {


        try {

            System.out.println("before connection");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("class");
            connection = DriverManager.getConnection(db_name, user, pass);

            System.out.println("after connection");
            System.out.println(connection);

        }catch (Exception e) {

            e.printStackTrace();
            System.out.println("can not connect, please check");


        }

    }
public Connection getConnection(){
    makeConnection(db_name, user, pass);
      return connection;
}
}
