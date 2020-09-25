package com.example.exam_second.controller;

import com.example.exam_second.model.Book;
import com.example.exam_second.service.BookService;
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
@RequestMapping(value = "/admin")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public String getIndex(Model model, @RequestParam(defaultValue = "") String by, @RequestParam(defaultValue = "") String val){
        return viewPage(model,null, null,false,by,val,1,"title","asc");
    }

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model, @Validated Book book, BindingResult bindingResult, boolean isError, String by, String val, @PathVariable int pageNum, String sortField, String sortDir){
        Pageable pageable = PageRequest.of(pageNum-1, 10,sortDir.equals("asc")? Sort.by(sortField).ascending():Sort.by(sortField).descending());
        Page<Book> res= bookService.search(by,val,pageable);
        model.addAttribute("res",res);
        model.addAttribute("by",by);
        model.addAttribute("val",val);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        if(isError)
            book.setPublishingDate(null);
        model.addAttribute("isError",isError);
        model.addAttribute("book",isError?book:new Book());
        return "book";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam int[] id, RedirectAttributes redirectAttributes){
        bookService.deleteByIds(id);
        redirectAttributes.addFlashAttribute("message","Deleted successful");
        return "redirect:/";
    }

    @PostMapping("/addEdit")
    public String addEditBlog(Model model,@Validated Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors())
            return viewPage(model,book, bindingResult,true,"","",1,"title","asc");

        redirectAttributes.addFlashAttribute("message",String.format("%s successful",(book.getId()>0?"Updated ":"Created ")+ book.getTitle()));
        bookService.save(book);
        return "redirect:/";
    }
}
