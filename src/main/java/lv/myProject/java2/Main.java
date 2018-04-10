package lv.myProject.java2;


import lv.myProject.java2.Configs.SpringAppConfig;
import lv.myProject.java2.ViewControllers.ManagePersons;
import lv.myProject.java2.businessLogic.*;
import lv.myProject.java2.businessLogic.AddPerson.AddPerson;
import lv.myProject.java2.businessLogic.RemovePerson.RemovePerson;
import lv.myProject.java2.businessLogic.ShowAll.ShowAllPerson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main  {



    public static void main(String[] args) {

            // Use cases:
            // 1. Add product to list
            // 2. Remove product from list
            // 3. Print shopping list to console
            // 4. Exit

            ApplicationContext applicationContext
                    = new AnnotationConfigApplicationContext(SpringAppConfig.class);

            Map<Integer,ManagePersons> actionMap = new HashMap<>();
            actionMap.put(1, applicationContext.getBean(AddPerson.class));
            actionMap.put(2, applicationContext.getBean(RemovePerson.class));
            actionMap.put(3, applicationContext.getBean(ShowAllPerson.class));
            actionMap.put(4, applicationContext.getBean(ProgrammExit.class));

            while (true) {
                printProgramMenu();
                int menuItem = getFromUserMenuItemToExecute();
                ManagePersons view = actionMap.get(menuItem);
                view.execute();
            }

        }

        private static void printProgramMenu() {
            System.out.println("Program Menu:\n");
            System.out.println("1. Add product to list");
            System.out.println("2. Remove product from list");
            System.out.println("3. Print list to console");
            System.out.println("4. Exit");
        }

        private static int getFromUserMenuItemToExecute() {
            System.out.print("Please enter menu item number to execute:");
            Scanner sc = new Scanner(System.in);
            return Integer.parseInt(sc.nextLine());
        }
}
