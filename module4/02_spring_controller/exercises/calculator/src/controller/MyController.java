package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @PostMapping("/cal")
    public ModelAndView cal(@RequestParam String val1, @RequestParam String val2, @RequestParam String operator) {
        double res=0;
        switch (operator) {
            case "+":
                res= Double.parseDouble(val1) + Double.parseDouble(val2);
                break;
            case "-":
                res= Double.parseDouble(val1) - Double.parseDouble(val2);
                break;
            case "*":
                res= Double.parseDouble(val1) * Double.parseDouble(val2);
                break;
            case "/":
                res= Double.parseDouble(val1) / Double.parseDouble(val2);
                break;
        }
        return new ModelAndView("index", "res", res);
    }
}
