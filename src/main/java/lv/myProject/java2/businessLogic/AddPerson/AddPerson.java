package lv.myProject.java2.businessLogic.AddPerson;

import lv.myProject.java2.ViewControllers.ManagePersons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddPerson implements ManagePersons {
    String firstName;
    String lastName;
    String phoneNumber;
    String returnedText;

    @Autowired
    private SessionFactory sessionFactory;
    private Session session() {
        return sessionFactory.getCurrentSession();
    }

@Override
public void execute(){

        System.out.println("aadd");
        session().save(person);


}



   /* public String addPerson(String lastName, String firstName, String phoneNumber){
        listOfPersonObjects.add(new Person(firstName,lastName,phoneNumber));
        System.out.println(listOfPersonObjects.size());
        returnedText="Good";
        return returnedText;
    }*/

}
