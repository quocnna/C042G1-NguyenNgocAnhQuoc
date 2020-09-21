package com.example.inotes.common;

import com.example.inotes.model.Note;
import com.example.inotes.service.bussiness.*;
import com.example.inotes.service.dao.NoteDAOImpl;
import com.example.inotes.service.dao.NoteTypeDAOImpl;
import com.example.inotes.service.file.NoteFileImpl;
import com.example.inotes.service.file.NoteTypeFileImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class Service {
    @Autowired
    BaseManager<Note> baseManager;
    @Autowired
    NoteManagerDB noteManagerDB;

    @Autowired
    NoteManagerFile noteManagerFile;

    public Service() {
        baseManager= noteManagerDB;
//        if("db".equals(StringUtil.serviceType))
//        baseManager= noteManagerDB;
//        else
//            baseManager= noteManagerFile;

    }


    public void test()
    {

    }
//    @Autowired
//    public BaseManager<Note> getNote(){
//        return this.baseManager;
//    }
//
//    @Autowired
//    public static NoteTypeManager getNoteType(){
//        return "db".equals(StringUtil.serviceType)? new NoteTypeManagerImpl(new QuocDAOImpl()):new NoteTypeManagerImpl(new NoteTypeFileImpl());
//    }
}
