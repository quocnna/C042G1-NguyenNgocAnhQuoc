package com.example.blog.controller.admin;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

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

//    @PostMapping("/blog/addEdit")
//    public String addEditBlog(Blog blog){
//        blogService.save(blog);
//        return "redirect:/admin";
//    }

    @RequestMapping(value = "/addEditBlog", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Blog addEditBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return blog;
    }




    @RequestMapping(value = "/abc", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getAdminIndex2(Model model, @RequestParam(defaultValue = "") String by, @RequestParam(defaultValue = "") String val ){
        List<Blog> test= viewPage2(model,by,val,1,"title","asc");
        return test;
    }

    @RequestMapping(value = "/viewpage2", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> viewPage2(Model model, String by, String val, @PathVariable int pageNum, String sortField, String sortDir){
        Pageable pageable = PageRequest.of(pageNum-1, 3,sortDir.equals("asc")?Sort.by(sortField).ascending():Sort.by(sortField).descending());
        Page<Blog> res= blogService.search(by,val,pageable);
        List<Blog> test= res.get().collect(Collectors.toList());
        return test;
    }
}
