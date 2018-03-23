package lv.myProject.java2.businessLogic;

import lv.myProject.java2.Domain.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ManagePersons {



    void addPerson() throws SQLException;
    void removePerson();
    List<Person> showAll();
    Optional<Person> findPerson();


}
