package com.example.phone_manager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="smartphones")
@Data
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String producer;
    private String model;
    private double price;
}
