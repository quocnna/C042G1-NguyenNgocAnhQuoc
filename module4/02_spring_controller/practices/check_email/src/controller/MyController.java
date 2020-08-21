package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class MyController {
    private static Pattern pattern_email = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
    //    private final String REX_EMAIL= "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private Pattern pattern;

    @GetMapping("/check_email")
    public ModelAndView checkEmail(@RequestParam String email) {
        boolean res = validateEmail(email);
        return new ModelAndView("index", "res", res);
    }

    //    private static boolean validate(String regex,String input){
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//        return matcher.matches();
//    }
    private static boolean validateEmail(String input) {
        Matcher matcher = pattern_email.matcher(input);
        return matcher.matches();
    }
}
