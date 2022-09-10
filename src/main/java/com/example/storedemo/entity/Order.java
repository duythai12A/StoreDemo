package com.example.storedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "o_id")
    private int oId;
    @Column(name = "time")
    private Instant time;

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pId",referencedColumnName = "pId",insertable = false,updatable = false)
    private List<Product> products;

    @OneToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cId",referencedColumnName = "cId",insertable = false,updatable = false)
    private Customer customer;
}
