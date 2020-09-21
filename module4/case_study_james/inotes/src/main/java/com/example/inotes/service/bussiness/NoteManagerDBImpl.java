package com.example.inotes.service.bussiness;

import com.example.inotes.common.IBase;
import com.example.inotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("db")
public class NoteManagerDBImpl implements NoteManagerDB {

    @Autowired
    @Qualifier("db")
    private IBase<Note> noteIBase;
    public NoteManagerDBImpl(@Qualifier("db") IBase<Note> noteIBase) {
        this.noteIBase = noteIBase;
    }

    @Override
    public Optional<Note> findById(int id) {
        return noteIBase.findById(id);
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteIBase.findAll(pageable);
    }

    @Override
    public void save(Note note) {
        noteIBase.save(note);
    }

    @Override
    public void deleteByIds(int[] ids) {
        Arrays.stream(ids).forEach(e->noteIBase.deleteByIds(ids));
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
