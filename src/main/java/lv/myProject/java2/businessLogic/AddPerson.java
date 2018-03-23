package lv.myProject.java2.businessLogic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lv.myProject.java2.Domain.Person;


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
