package com.example.storedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "c_id")
    private int cId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "city")
    private String city;
    @Column(name = "sdt")
    private String sdt;
    @OneToOne(targetEntity = Role.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    private Role role;
}
