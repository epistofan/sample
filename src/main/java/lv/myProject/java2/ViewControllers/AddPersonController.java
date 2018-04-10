package lv.myProject.java2.ViewControllers;



import lv.myProject.java2.Domain.Person;

import lv.myProject.java2.businessLogic.AddPerson.AddPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddPersonController implements ManagePersons {


    @Autowired
    AddPerson addPerson;

    @Override
    public void execute() {
        Person person = new Person();
        person.setEmail("dssddsdssd");
        person.setFirstName("eaaaaaaaaaaaa");
        person.setLastName("dcsdcsdcsdcsc");
        person.setPersonCode("dewdwedwedwed434534");
        person.setPhoneNumber("3454543");
        addPerson.addPerson(person);
    }
}
