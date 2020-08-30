package qg.exercise.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;

    @Column(name = "like_number", columnDefinition="integer default 5")
    private int like_number;

    @OneToMany(mappedBy = "picture", cascade = CascadeType.ALL)
    private Collection<Comment> comments;
}
