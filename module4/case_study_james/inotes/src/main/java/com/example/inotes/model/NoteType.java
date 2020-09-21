package com.example.inotes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Entity
@Table(name="note_type")
public class NoteType extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "noteType")
    private Collection<Note> notes;
}
