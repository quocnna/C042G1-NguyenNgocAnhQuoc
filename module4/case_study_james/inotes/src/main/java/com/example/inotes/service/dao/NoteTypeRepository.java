package com.example.inotes.service.dao;

import com.example.inotes.model.NoteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteTypeRepository extends JpaRepository<NoteType,Integer> { }
