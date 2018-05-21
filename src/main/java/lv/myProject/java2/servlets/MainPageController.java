package lv.myProject.java2.servlets;

import lv.myProject.java2.Domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {


    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("loginPage", "user", new User());
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUser(@ModelAttribute("user") User user,

                             ModelMap model) {
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("userPassword", user.getUserPassword());


        return "result";
    }
}
