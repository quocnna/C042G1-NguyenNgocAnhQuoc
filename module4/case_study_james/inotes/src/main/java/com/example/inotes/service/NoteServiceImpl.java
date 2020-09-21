package com.example.inotes.service;

import com.example.inotes.common.IBase;
import com.example.inotes.model.Note;
import com.example.inotes.service.bussiness.BaseManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class NoteServiceImpl implements NoteService {
    private BaseManager<Note> noteBaseManager;
    public NoteServiceImpl(BaseManager<Note> noteBaseManager){
        this.noteBaseManager= noteBaseManager;
    }

    @Override
    public Optional<Note> findById(int id) {
        noteBaseManager.findById(1);
        return Optional.empty();
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Note note) {

    }

    @Override
    public void deleteByIds(int[] ids) {

    }

    @Override
    public Page<Note> search(String by, String val, Pageable pageable) {
        return null;
    }

    @Override
    public List<Note> getAll() {
        return null;
    }
}
