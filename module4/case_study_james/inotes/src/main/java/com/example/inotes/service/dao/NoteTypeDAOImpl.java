package com.example.inotes.service.dao;

import com.example.inotes.model.NoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class NoteTypeDAOImpl implements NoteTypeDAO {

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
    public void deleteByIds(int[] ids) {

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
