package com.example.inotes.service.bussiness;

import com.example.inotes.model.NoteType;

import java.util.List;

public interface NoteTypeManager extends BaseManager<NoteType> {
    List<NoteType> getAll();
}
