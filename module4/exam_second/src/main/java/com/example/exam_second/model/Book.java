package com.example.exam_second.model;

import com.example.exam_second.common.DateValid;
import com.example.exam_second.common.NumberValid;
import com.example.exam_second.common.StringValid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Title not empty")
    private String title;
    @NotEmpty(message = "Author not empty")
    @StringValid
    private String author;
    @NumberValid
    private double price;

    @DateValid
    @Column(columnDefinition="DATE")
    private LocalDate publishingDate= LocalDate.now();

    @NotEmpty
    private String description;
}
