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
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String getAdminIndex(Model model, @RequestParam(defaultValue = "") String by, @RequestParam(defaultValue = "") String val){
        return viewPage(model,by,val,1,"title","asc");
    }

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model, String by,String val,@PathVariable int pageNum,String sortField, String sortDir){
        Pageable pageable = PageRequest.of(pageNum-1, 3,sortDir.equals("asc")?Sort.by(sortField).ascending():Sort.by(sortField).descending());
        Page<Blog> res= blogService.search(by,val,pageable);
        model.addAttribute("cate",categoryService.getAll());
        model.addAttribute("res",res);
        model.addAttribute("by",by);
        model.addAttribute("val",val);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        return "admin/blog";
    }

    @PostMapping("/blog/delete")
    public String deleteBlog(@RequestParam int[] id){
        blogService.deleteByIds(id);
        return "redirect:/admin";
    }

    @PostMapping("/blog/addEdit")
    public String addEditBlog(Blog blog){
        blogService.save(blog);
        return "redirect:/admin";
    }
}
