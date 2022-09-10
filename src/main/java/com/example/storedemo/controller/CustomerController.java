package com.example.storedemo.controller;

import com.example.storedemo.entity.Customer;
import com.example.storedemo.repository.CustomerRepository;
import com.example.storedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @GetMapping("/list_customer")
    public List<Customer> getStudents(){
        return service.customers();
    }
    @GetMapping("/find_customer/{id}")
    public Customer customer(@PathVariable(value = "id") int id){
        return service.findCustomer(id);
    }
    @PostMapping("/add_customer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

}
