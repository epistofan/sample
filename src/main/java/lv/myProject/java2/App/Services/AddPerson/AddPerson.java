package lv.myProject.java2.App.Services.AddPerson;


import org.springframework.stereotype.Component;

@Component
public class AddPerson {
    String firstName;
    String lastName;
    String phoneNumber;
    String returnedText;
 public void test(){
    System.out.println("test");
}
   /*
    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void addPerson(Person person){

        System.out.println("aadd");
        session().save(person);


}*/




}
