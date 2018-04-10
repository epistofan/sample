package lv.myProject.java2.businessLogic.AddPerson;


import lv.myProject.java2.Domain.Person;

import lv.myProject.java2.ViewControllers.ManagePersons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AddPerson {
    String firstName;
    String lastName;
    String phoneNumber;
    String returnedText;

    @Autowired
    private SessionFactory sessionFactory;
    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void addPerson(Person person){

        System.out.println("aadd");
        session().save(person);


}




}
