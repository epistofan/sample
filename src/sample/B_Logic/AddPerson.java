package sample.B_Logic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Person;
import sample.Logic.*;

public class AddPerson {
    String firstName;
    String lastName;
    String phoneNumber;
    String returnedText;

    ObservableList<Person> listOfPersonObjects = FXCollections.observableArrayList();



    public String addPerson(String lastName, String firstName, String phoneNumber){
        listOfPersonObjects.add(new Person(firstName,lastName,phoneNumber));
        System.out.println(listOfPersonObjects.size());
        returnedText="Good";
        return returnedText;
    }

}
