package lv.myProject.java2.App.Web;

import lv.myProject.java2.App.Domain.User;
import lv.myProject.java2.App.AddPerson.AddPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component

public class UserRegistrationValidator{


    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    AddPerson addPerson;

    Session session() {
        return sessionFactory.getCurrentSession();
    }
    @Transactional
     public boolean validate(User user){


        System.out.println(user.getUserName());
        String hql = "FROM users";


            try {
                addPerson.test();

                System.out.println(session());

                }catch (RuntimeException e) {e.printStackTrace();
            }




         return true;
     }
}
