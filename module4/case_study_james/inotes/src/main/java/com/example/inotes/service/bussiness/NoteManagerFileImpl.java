package com.example.inotes.service.bussiness;

import com.example.inotes.common.IBase;
import com.example.inotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("file")
public class NoteManagerFileImpl implements NoteManagerFile {
    @Autowired
    @Qualifier("file")
    private IBase<Note> noteIBase;
    public NoteManagerFileImpl(@Qualifier("file") IBase<Note> noteIBase) {
        this.noteIBase = noteIBase;
    }

    @Override
    public Optional<Note> findById(int id) {
        noteIBase.findById(1);
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
