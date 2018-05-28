package lv.myProject.java2.App.Web;

import lv.myProject.java2.App.Domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkPageController {

    @RequestMapping(value = "/workPage", method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("workPage");
    }


}
