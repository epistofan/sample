package lv.myProject.java2.servlets;


import lv.myProject.java2.businessLogic.AddPerson.AddPerson;
import lv.myProject.java2.businessLogic.AddPerson.AddPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class HelloWorldController {

    //private static Logger logger = Logger.getLogger(HelloWorldController.class.getName());

    @Autowired
    private AddPersonService addPersonService;

    @RequestMapping(value = "/*", method = {RequestMethod.GET})
    public String home() {

        return "helloWorld";
    }


    @RequestMapping(value = "/checkUser", method = {RequestMethod.POST})
    public String checkUser() {

        return "mainPage";
    }
    /*@RequestMapping(value = "hello", method = {RequestMethod.GET})
    public ModelAndView process(HttpServletRequest request) {

        String productTitle = request.getParameter("title");
        String productDescription = request.getParameter("description");

        addPersonService.addPerson(productTitle, productDescription);

        return new ModelAndView("helloWorld", "model", "Hello from MVC!");
    }*/

}