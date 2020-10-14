package com.example.exam_second.controller;

import com.example.exam_second.model.Product;
import com.example.exam_second.service.CategoryService;
import com.example.exam_second.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    @GetMapping
    public String getIndex(Model model, @RequestParam(defaultValue = "") String by, @RequestParam(defaultValue = "") String val){
        return viewPage(model,null, null,false,by,val,1,"name","asc");
    }

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model, @Validated Product product, BindingResult bindingResult, boolean isError, String by, String val, @PathVariable int pageNum, String sortField, String sortDir){
        Pageable pageable = PageRequest.of(pageNum-1, 5,sortDir.equals("asc")? Sort.by(sortField).ascending():Sort.by(sortField).descending());
        Page<Product> res= productService.search(by,val,pageable);
        model.addAttribute("cate",categoryService.getAll());
        model.addAttribute("res",res);
        model.addAttribute("by",by);
        model.addAttribute("val",val);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("isError",isError);
        model.addAttribute("product",isError?product:new Product());
        return "product_auction";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int[] id, RedirectAttributes redirectAttributes){
        productService.deleteByIds(id);
        redirectAttributes.addFlashAttribute("message","Deleted successful");
        return "redirect:/";
    }

    @PostMapping("/addEdit")
    public String addEdit(Model model,@Validated Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors())
            return viewPage(model,product, bindingResult,true,"","",1,"name","asc");

        redirectAttributes.addFlashAttribute("message",String.format("%s successful",(product.getId()>0?"Updated ":"Created ")+ product.getName()));
        productService.save(product);
        return "redirect:/";
    }
}
