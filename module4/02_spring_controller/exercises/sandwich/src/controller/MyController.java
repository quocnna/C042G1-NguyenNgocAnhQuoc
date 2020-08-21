package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @GetMapping("/sandwich")
    public String getIndex(){
        return  "sandwich";
    }

    @PostMapping("/sandwich")
    public ModelAndView getCondiment(@RequestParam String condiment){
        return new ModelAndView("sandwich","res",condiment);
    }
}
