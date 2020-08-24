package com.example.product.controller;

import com.example.product.bussiness.ProductService;
import com.example.product.bussiness.ProductServiceImpl;
import com.example.product.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    private static ProductService<Product> products = new ProductServiceImpl();

    @GetMapping("/")
    public ModelAndView getIndex(){
        return new ModelAndView("index","res",products.getAll());
    }

    @PostMapping("/addEdit")
    public String addEdit(Product product){
        int res= product.getId()>0?products.update(product):products.save(product);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id){
        products.removeById(id);
        return "redirect:/";
    }
}
