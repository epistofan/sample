package lv.myProject.java2.businessLogic;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class PersonDatabase implements ManagePersons{

    Connection connection1;
    protected String user;
    String pass;
    String db_name;
    Statement statement;
    ResultSet resultSet;
    DatabaseSource databaseSource;

    public PersonDatabase(DatabaseSource databaseSource) {
        this.databaseSource = databaseSource;
    }

    @Override
    public void addPerson() throws SQLException {
            connection1=databaseSource.connection;
           // connection1 = getConnection();
            String SQL = "SELECT TOP 10 * FROM [test].[dbo].[table]";
            System.out.println(connection1+" "+"addPerson");
            statement = connection1.createStatement();
            System.out.println("statement");
            resultSet = statement.executeQuery(SQL);
            System.out.println("query executing");

    }

    @Override
    public void removePerson() {
System.out.println("test");
    }

    @Override
    public List<Person> showAll() {

        return null;
    }



    @Override
    public Optional<Person> findPerson() {

        return null;
    }
}
