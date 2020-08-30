package controller;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    @GetMapping("/edit")
    public ModelAndView setting(){
         return new ModelAndView("setting","res",Setting.getInstance());
    }

    @PostMapping("/update")
    public String update(Setting setting){
//        Setting aaa= new Setting.Builder().withLanguage("").withPageSize().build();
        Setting s= Setting.getInstance();
        s.setLanguage(setting.getLanguage());
        s.setPageSize(setting.getPageSize());
        s.setSpamFilter(setting.isSpamFilter());
        s.setSingature(setting.getSingature());
        return "index";
    }
}
