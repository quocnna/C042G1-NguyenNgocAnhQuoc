package com.example.inotes.service.bussiness;

import com.example.inotes.common.IBase;
import com.example.inotes.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NoteTypeManagerImpl implements NoteTypeManager {
    private IBase<NoteType> noteTypeIBase;

    public NoteTypeManagerImpl(IBase<NoteType> noteTypeIBase) {
        this.noteTypeIBase = noteTypeIBase;
    }

    @Override
    public Optional<NoteType> findById(int id) {
        return noteTypeIBase.findById(id);
    }

    @Override
    public Page<NoteType> findAll(Pageable pageable) {
        return noteTypeIBase.findAll(pageable);
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeIBase.save(noteType);
    }

    @Override
    public void deleteByIds(int[] ids) {
        Arrays.stream(ids).forEach(i -> noteTypeIBase.deleteByIds(ids));
    }

    @Override
    public Page<NoteType> search(String by, String val, Pageable pageable) {
        return null;
    }

    @Override
    public List<NoteType> getAll() {
        return noteTypeIBase.getAll();
    }
}
