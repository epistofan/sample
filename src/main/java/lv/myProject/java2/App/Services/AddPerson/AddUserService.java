package lv.myProject.java2.App.Services.AddPerson;

import lv.myProject.java2.App.Domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddUserService {

    @Autowired
    SessionFactory sessionFactory;

    String userN;
    String userP;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    public String validate(User user){

        //String hql = "FROM User";

        String hql = "FROM User WHERE userName= :userName";
        String userName = user.getUserName();
        Query query = session().createQuery(hql);
        query.setParameter("userName", userName);

        List<User> results = query.list();
        System.out.println(results);
        for(User user1:results) {

            System.out.println(user1);
            userN = user1.getUserName();
            userP = user1.getUserName();
        }



            return userN;
        }


    }



