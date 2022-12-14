package com.example.storedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "order_product")
public class Order {
    @Id
    @Column(name = "o_id")
    private int oId;
    @Column(name = "time_order")
    private Instant time;

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id",referencedColumnName = "p_id",insertable = false,updatable = false)
    private List<Product> products;

    @OneToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "c_id",referencedColumnName = "c_id",insertable = false,updatable = false)
    private Customer customer;
}
