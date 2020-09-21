package com.example.inotes.service.file;

import com.example.inotes.model.Note;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("file")
public class NoteFileImpl implements NoteFile {
    @Override
    public Optional<Note> findById(int id) {
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
    public void deleteByIds(int[] id) {

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
