package lv.myProject.java2.businessLogic;

import lv.myProject.java2.Domain.Person;
import lv.myProject.java2.Domain.Person1;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ManagePersons {



    void addPerson(Person1 person) throws SQLException;
    void removePerson();
    List<Person> showAll();
    Optional<Person> findPerson();


}
