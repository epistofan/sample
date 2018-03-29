package lv.myProject.java2.businessLogic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lv.myProject.java2.Domain.Person;
import lv.myProject.java2.Domain.Person1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Optional;

@Component
public class PersonDatabaseManagement implements ManagePersons{

    Connection connection1;
    protected String user;
    String pass;
    String db_name;
    Statement statement;
    ResultSet resultSet;
    ObservableList<Person1> personList = FXCollections.observableArrayList();

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
            personList=null;
            connection1 = databaseSource.connection;
            System.out.println("add Person");
            String SQL = "INSERT INTO [Person].[dbo].[Person] (FirstName, LastName, PersonCode, Email, PhoneNumber)" +
                    "VALUES (?, ?, ?, ?, ?);";
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
    public ObservableList<Person1> showAll() {
       // personList=null;
        connection1 = databaseSource.connection;
        try {
            System.out.println("show all Persons");
            String SQL = "SELECT * FROM [Person].[dbo].[Person]";
            System.out.println(connection1 + " " + "addPerson");
            PreparedStatement preparedStatement = connection1.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person1 person = new Person1();
                person.setId(resultSet.getLong("ID"));
                person.setFirstName(resultSet.getString("FirstName"));
                person.setLastName(resultSet.getString("LastName"));
                personList.add(person);
            }
        }catch (Exception e){

        }
        return personList;
    }



    @Override
    public Optional<Person> findPerson() {

        return null;
    }
}
