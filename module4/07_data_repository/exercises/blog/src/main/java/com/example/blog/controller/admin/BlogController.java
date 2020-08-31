package com.example.blog.controller.admin;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String getAdminIndex(Model model, @RequestParam(defaultValue = "") String by, @RequestParam(defaultValue = "") String val){
        return viewPage(model,null, null,false,by,val,1,"title","asc");
    }

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model,@Validated Blog blog, BindingResult bindingResult, boolean isError, String by,String val,@PathVariable int pageNum,String sortField, String sortDir){
        Pageable pageable = PageRequest.of(pageNum-1, 10,sortDir.equals("asc")?Sort.by(sortField).ascending():Sort.by(sortField).descending());
        Page<Blog> res= blogService.search(by,val,pageable);
        model.addAttribute("cate",categoryService.getAll());
        model.addAttribute("res",res);
        model.addAttribute("by",by);
        model.addAttribute("val",val);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("blog",isError?blog:new Blog());
        return "admin/blog";
    }

    @PostMapping("/blog/delete")
    public String deleteBlog(@RequestParam int[] id, RedirectAttributes redirectAttributes){
        blogService.deleteByIds(id);
        redirectAttributes.addFlashAttribute("message","Deleted successful");
        return "redirect:/admin";
    }

    @PostMapping("/blog/addEdit")
    public String addEditBlog(Model model, @Validated Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors())
            return viewPage(model,blog, bindingResult,true,"","",1,"title","asc");

        redirectAttributes.addFlashAttribute("message",String.format("%s successful",(blog.getId()>0?"Updated ":"Created ")+ blog.getTitle()));
        blogService.save(blog);
        return "redirect:/admin";
    }
}
