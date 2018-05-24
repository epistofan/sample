package lv.myProject.java2.App.businessLogic;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    boolean isEmpty;

    public Boolean validateDatabaseNameIsEmpty(String dataBaseName) {
        if(dataBaseName.isEmpty()){
            System.out.println("empty");
            isEmpty=true;
        }

        return isEmpty;
    }





}
