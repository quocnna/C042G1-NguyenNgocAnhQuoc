package com.example.my_security.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_token")
public class Token extends BaseEntity {
    @Column(length = 1000)
    private String token;
    private Date tokenExpDate;
}
