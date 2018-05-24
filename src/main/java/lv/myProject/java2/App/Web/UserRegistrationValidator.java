package lv.myProject.java2.App.Web;

import lv.myProject.java2.App.AddPerson.AddUserService;
import lv.myProject.java2.App.Domain.User;
import lv.myProject.java2.App.AddPerson.AddPerson;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserRegistrationValidator{

    @Autowired
    AddUserService addUserService;


    @Transactional
     public boolean validate(User user){

            addUserService.validate(user);

            return true;
     }
}
