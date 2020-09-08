package com.example.counter.controller;

import com.example.counter.model.MyCounter;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes("mycounter")
public class CounterController {

    /* add MyCounter in model attribute */
//    @ModelAttribute("mycounter")
//    public MyCounter setUpCounter() {
//        return new MyCounter();
//    }

    @GetMapping("/")
    public String get(@ModelAttribute("mycounter") MyCounter myCounter, HttpServletRequest request, HttpServletResponse response) {
//        Gson gson = new Gson();
//        String test= gson.toJson(myCounter);
       //test= test.replace("\"","");
//        Cookie cookie = new Cookie("JSESSIONID", "B203DE6C0F4318A45FB032AB084C1656");
//        cookie.setMaxAge(24 * 60 * 60);
//        response.addCookie(cookie);
//


//        myCounter.increment();

        HttpSession session = request.getSession();
        String id= session.getId();
        Cookie cookie = new Cookie("JSESSIONID", id);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        Object o= session.getAttribute("count");
        int i=o!=null?Integer.parseInt(o.toString())+1:1;
        session.setAttribute("count", i);
//        session.setMaxInactiveInterval(6000);
        //session.getAttribute("mycounter");

        return "index";
    }
}
