package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    @GetMapping("/translate")
    public String translate(){
        return "dictionary";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam String eng, Model model){
        Map<String, String> dic = new HashMap<>();
        dic.put("hello","xin chao");
        dic.put("world","the gioi");
        dic.put("beautiful","xinh dep");
        model.addAttribute("eng",eng);
        model.addAttribute("res",dic.get(eng)!=null?dic.get(eng):"not found");
        return "dictionary";
    }
}
