package com.example.cart.controller;

import com.example.cart.model.Products;
import com.example.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/")
    public ModelAndView getIndex(){
        List<Products> res= productService.findAll();
        return new ModelAndView("index","res",res);
    }

    @RequestMapping("/checkout")
    public ModelAndView getCheckOut(){
        return new ModelAndView("checkout");
    }
}
