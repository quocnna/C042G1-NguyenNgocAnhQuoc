package com.example.examination.controller;

import com.example.examination.model.Book;
import com.example.examination.service.BookService;
import com.example.examination.service.CategoryService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;

    @GetMapping
    public String getIndex(Model model, @RequestParam(defaultValue = "") String by, @RequestParam(defaultValue = "") String val){
        return viewPage(model,null, null,false,by,val,1,"title","asc");
    }

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model, @Validated Book book, BindingResult bindingResult, boolean isError, String by, String val, @PathVariable int pageNum, String sortField, String sortDir){
        Pageable pageable = PageRequest.of(pageNum-1, 10,sortDir.equals("asc")? Sort.by(sortField).ascending():Sort.by(sortField).descending());
        Page<Book> res= bookService.search(by,val,pageable);
        model.addAttribute("cate",categoryService.getAll());
        model.addAttribute("res",res);
        model.addAttribute("by",by);
        model.addAttribute("val",val);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("ent",isError?book:new Book());
        return "/book";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam int[] id, RedirectAttributes redirectAttributes){
        bookService.deleteByIds(id);
        redirectAttributes.addFlashAttribute("message","Deleted successful");
        return "redirect:/book";
    }

    @PostMapping("/addEdit")
    public String addEditBlog(Model model, @ModelAttribute Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors())
            return viewPage(model,book, bindingResult,true,"","",1,"title","asc");

        redirectAttributes.addFlashAttribute("message",String.format("%s successful",(book.getId()>0?"Updated ":"Created ")+ book.getTitle()));
        bookService.save(book);
        return "redirect:/book";
    }
}
