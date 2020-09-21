package com.example.inotes.controller;

import com.example.inotes.common.Service;
import com.example.inotes.common.StringUtil;
import com.example.inotes.model.Note;
import com.example.inotes.service.NoteService;
import com.example.inotes.service.NoteServiceImpl;
import com.example.inotes.service.bussiness.BaseManager;
import com.example.inotes.service.bussiness.NoteManagerDB;
import com.example.inotes.service.bussiness.NoteManagerDBImpl;
import com.example.inotes.service.bussiness.NoteManagerFile;
import com.example.inotes.service.dao.NoteDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/note")
public class NoteController {
    BaseManager<Note> baseManager;
    @Autowired
    NoteManagerDB noteManagerDB;

    @Autowired
    NoteManagerFile noteManagerFile;

    public  BaseManager<Note> getNote(){
       return  "db".equals(StringUtil.serviceType)?noteManagerDB:noteManagerFile;
//        baseManager= noteManagerDB;
    }


//    @Autowired
//    NoteService noteService;
    @GetMapping
    public String getAdminIndex(Model model, @RequestParam(defaultValue = "") String by, @RequestParam(defaultValue = "") String val) throws Exception {
            getNote().findById(1);
//        baseManager.findById(1);
        return null;
//        return viewPage(model,null, null,false,by,val,1,"title","asc");
    }

//    @GetMapping("/page/{pageNum}")
//    public String viewPage(Model model, @Validated Note note, BindingResult bindingResult, boolean isError, String by, String val, @PathVariable int pageNum, String sortField, String sortDir){
//        Pageable pageable = PageRequest.of(pageNum-1, 3,sortDir.equals("asc")? Sort.by(sortField).ascending():Sort.by(sortField).descending());
//        Page<Note> res= Service.getNote().search(by,val,pageable);
//        model.addAttribute("test",Service.getNote().findById(1));
//        model.addAttribute("cate",Service.getNoteType().findById(1));
//        model.addAttribute("res",res);
//        model.addAttribute("by",by);
//        model.addAttribute("val",val);
//        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//        model.addAttribute("blog",isError?note:new Note());
//        return "/note";
//    }
//
//    @PostMapping("/delete")
//    public String deleteBlog(@RequestParam int[] id, RedirectAttributes redirectAttributes){
//        Service.getNote().deleteByIds(id);
//        redirectAttributes.addFlashAttribute("message","Deleted successful");
//        return "redirect:/note";
//    }
//
//    @PostMapping("/addEdit")
//    public String addEditBlog(Model model, @Validated Note note, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if (bindingResult.hasFieldErrors())
//            return viewPage(model,note, bindingResult,true,"","",1,"title","asc");
//
//        redirectAttributes.addFlashAttribute("message",String.format("%s successful",(note.getId()>0?"Updated ":"Created ")+ note.getTitle()));
//        Service.getNote().save(note);
//        return "redirect:/note";
//    }
}
