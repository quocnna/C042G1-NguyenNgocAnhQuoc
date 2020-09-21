package com.example.inotes.service.file;

import com.example.inotes.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class NoteTypeFileImpl implements NoteTypeFile {
    @Override
    public Optional<NoteType> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Page<NoteType> findAll(Pageable pageable) {
        return null;
    }


    @Override
    public void save(NoteType noteType) {

    }

    @Override
    public void deleteByIds(int[] id) {

    }

    @Override
    public Page<NoteType> search(String by, String val, Pageable pageable) {
        return null;
    }

    @Override
    public List<NoteType> getAll() {
        return null;
    }
}
