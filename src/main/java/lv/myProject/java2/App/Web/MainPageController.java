package lv.myProject.java2.App.Web;

import lv.myProject.java2.App.Domain.User;
import lv.myProject.java2.App.businessLogic.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {



    @Autowired
    UserRegistrationValidator userRegistrationValidator;
    @Autowired
    WorkPageController workPageController;


    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("loginPage", "user", new User());
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUser(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("userPassword", user.getUserPassword());


        if(userRegistrationValidator.validate(user)){
            return "result";
        }else {
            model.addAttribute("failMessage", "User not found ;(");
           // workPageController.main();
            return "loginPage";
        }
    }
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome!");
    }
}
