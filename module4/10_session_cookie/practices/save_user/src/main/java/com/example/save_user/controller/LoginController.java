package com.example.save_user.controller;

import com.example.save_user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/")
    public String test(HttpServletResponse response){
        Cookie cookie = new Cookie("aaaa", "aaaa");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                         HttpServletResponse response, HttpServletRequest request) {

        if (user.getEmail().equals("123") && user.getPassword().equals("123")) {
                setUser = user.getEmail();

            // create cookie and set it in response
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            Cookie cookiePassword= new Cookie("setPassword",user.getPassword());
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookiePassword);

            //get all cookies
            Cookie[] cookies = request.getCookies();
            //iterate each cookie
            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setUser'
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }
}
