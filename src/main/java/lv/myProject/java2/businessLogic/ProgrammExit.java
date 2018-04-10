package lv.myProject.java2.businessLogic;


import lv.myProject.java2.ViewControllers.ManagePersons;
import org.springframework.stereotype.Component;

@Component
public class ProgrammExit implements ManagePersons {

    @Override
    public void execute() {
        System.out.println("Exiting...");
        System.exit(1);
    }
}
