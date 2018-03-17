package sample.B_Logic;

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
