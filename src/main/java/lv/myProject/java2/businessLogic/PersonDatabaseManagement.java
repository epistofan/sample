package lv.myProject.java2.businessLogic;

import lv.myProject.java2.Domain.Person;
import lv.myProject.java2.Domain.Person1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDatabaseManagement implements ManagePersons{

    Connection connection1;
    protected String user;
    String pass;
    String db_name;
    Statement statement;
    ResultSet resultSet;

    @Autowired
    DatabaseSource databaseSource;
/*
    public PersonDatabase(DatabaseSource databaseSource) {
        this.databaseSource = databaseSource;
    }
*/
    @Override
    public void addPerson(Person1 person) throws SQLException {
        try {
            connection1 = databaseSource.connection;
            System.out.println("add Person");
            String SQL = "INSERT INTO [Person].[dbo].[Person] (ID, FirstName, LastName, PersonCode, Email, PhoneNumber)" +
                    "VALUES (9, ?, ?, ?, ?, ?, ?);";
            System.out.println(connection1 + " " + "addPerson");

            PreparedStatement preparedStatement =
                    connection1.prepareStatement(SQL);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getPersonCode());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, person.getPhoneNumber());

            preparedStatement.executeUpdate();
            System.out.println("statement");
            /*resultSet = statement.executeQuery(SQL);
            System.out.println("query executing");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            */
        }catch (Exception e) {
            e.printStackTrace();
        }

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
