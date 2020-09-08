package com.example.cart.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @Column(columnDefinition="DATE")
    private LocalDate orderDate;
    @Column(columnDefinition="DATE")
    private LocalDate shipDate;
    @Column(columnDefinition="DATE")
    private LocalDate requireDate;
    private boolean status;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customers customer;

    @OneToMany(mappedBy = "orders")
    private Collection<OrdersDetail> ordersDetails;
}
