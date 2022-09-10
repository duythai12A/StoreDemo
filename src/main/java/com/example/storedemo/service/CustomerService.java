package com.example.storedemo.service;

import com.example.storedemo.entity.Customer;
import com.example.storedemo.repository.CustomerRepository;
import com.example.storedemo.repository.OrderRepository;
import com.example.storedemo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private OrderRepository orderRepository;
    public List<Customer> customers(){
        return  customerRepository.findAll();
    }
    public Customer findCustomer(int id){
        return customerRepository.findById(id).get();
    }
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "removed customer id = "+id;
    }
    public Customer updateCustomer(Customer customer){
        Customer customerUpdate = customerRepository.findById(customer.getCId()).orElse(null);
        customerUpdate.setAge(customer.getAge());
        customerUpdate.setCity(customer.getCity());
        customerUpdate.setName(customer.getName());
        customerUpdate.setSdt(customer.getSdt());
        customerUpdate.getRole().setAccountId(customer.getRole().getAccountId());
        customerUpdate.getRole().setRole(customer.getRole().getRole());
        customerUpdate.getRole().setPassword(customer.getRole().getPassword());
        customerUpdate.getRole().setUserName(customer.getRole().getUserName());
        return customerRepository.save(customerUpdate);
    }

}
