package com.example.cart.model;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imgUrl;
    private String color;
    private double price;
    private String description;

    @OneToMany(mappedBy = "products")
    private Collection<OrdersDetail> ordersDetails;
}
