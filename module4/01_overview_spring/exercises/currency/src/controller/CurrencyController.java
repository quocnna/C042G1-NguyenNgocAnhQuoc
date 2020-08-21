package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/convert")
    public String convert(){
        return "index";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam String usd, Model model){
        Double res=  23000* Double.parseDouble(usd);
        model.addAttribute("usd",usd);
        model.addAttribute("res",res.toString());
        return "index";
    }


}
