package com.example.storedemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "p_id")
    private int pId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private float price;
}
