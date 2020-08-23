package controller;

import model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @PostMapping("/login")
    public ModelAndView login(Login login){
        String res="quoc".equals(login.getUsername()) && "admin".equals(login.getPassword())?"sucess":"fail";
        return new ModelAndView("index","res",res);
    }
}
