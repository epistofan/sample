package lv.myProject.java2.Domain;


import org.springframework.stereotype.Component;

import javax.persistence.Entity;


public class User {

    private String userName;
    private String userPassword;




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
