package com.example.inotes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="note")
public class Note extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "note_type_id")
    private NoteType noteType;
}
