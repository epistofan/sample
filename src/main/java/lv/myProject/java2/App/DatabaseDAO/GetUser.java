package lv.myProject.java2.App.DatabaseDAO;

import lv.myProject.java2.App.Domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUser {


    @Autowired
    SessionFactory sessionFactory;

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
        results.forEach(result -> System.out.println(user.getUserName()));

        return user.getUserName();
    }



}
