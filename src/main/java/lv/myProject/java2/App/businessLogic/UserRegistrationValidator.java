package lv.myProject.java2.App.businessLogic;

import lv.myProject.java2.App.Services.AddPerson.AddUserService;
import lv.myProject.java2.App.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UserRegistrationValidator{

    @Autowired
    AddUserService addUserService;


    @Transactional
     public boolean validate(User user){
        if(user.getUserName().equals(addUserService.validate(user))){
            return true;
        }else{
            return false;
        }



     }
}
