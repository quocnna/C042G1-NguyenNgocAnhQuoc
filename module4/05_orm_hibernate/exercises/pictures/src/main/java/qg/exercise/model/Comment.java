package qg.exercise.model;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment", columnDefinition="varchar(255) default 'test'")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "picture_id")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
    private Picture picture;
}
