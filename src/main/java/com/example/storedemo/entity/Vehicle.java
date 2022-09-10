package com.example.storedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id")
    private int vehicleId;
    @Column(name = "type")
    private String type;
    @Column(name = "color")
    private String color;
    @OneToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "c_id",referencedColumnName = "c_id",insertable = false,updatable = false)
    private Customer customer;

}
