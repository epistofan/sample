package lv.myProject.java2.businessLogic;

import javafx.collections.ObservableList;
import lv.myProject.java2.Domain.Person;
import lv.myProject.java2.Domain.Person1;

import java.sql.SQLException;
import java.util.Optional;

public interface ManagePersons {



    void addPerson(Person1 person) throws SQLException;
    void removePerson();
    ObservableList<Person1> showAll();
    Optional<Person> findPerson();


}
