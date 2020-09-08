package com.example.blog.model;

import com.example.blog.Common.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition="CHAR(150)")
    private String title;
    @Column(columnDefinition="TEXT")
    private String content;
    private String imageUrl;
    private int likes;
    @Column(columnDefinition="DATE")
    private LocalDate createdOn;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Category category;

//    public Blog(String val){
//        this.title=val;
//        this.content= val;
//        this.imageUrl= val;
//        this.likes= StringUtil.parseIntegerOrDefault(val);
//        this.category.setName(val);
//    }
}
