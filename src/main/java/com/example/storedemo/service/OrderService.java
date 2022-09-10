package com.example.storedemo.service;

import com.example.storedemo.entity.Order;
import com.example.storedemo.repository.CustomerRepository;
import com.example.storedemo.repository.OrderRepository;
import com.example.storedemo.repository.ProductRepository;
import com.example.storedemo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(){
       return orderRepository.findAll();
    }
    public Order findOrderById(int id){
        return orderRepository.findById(id).get();
    }
    public Order addOrder(Order order){
        return orderRepository.save(order);
    }
    public String deleteOrder(int id){
        orderRepository.deleteById(id);
        return "removed order id = "+id;
    }
    public Order updateOrder(Order order){
        Order orderUpdate = orderRepository.findById(order.getOId()).get();
        orderUpdate.setTime(order.getTime());
        orderUpdate.getCustomer().setCity(order.getCustomer().getCity());
        orderUpdate.getCustomer().setName(order.getCustomer().getName());
        orderUpdate.getCustomer().setSdt(order.getCustomer().getSdt());
        orderUpdate.getCustomer().setAge(order.getCustomer().getAge());
        orderUpdate.getCustomer().getRole().setRole(order.getCustomer().getRole().getRole());
        orderUpdate.getCustomer().getRole().setUserName(order.getCustomer().getRole().getUserName());
        orderUpdate.getCustomer().getRole().setPassword(order.getCustomer().getRole().getPassword());
        orderUpdate.getCustomer().getRole().setAccountId(order.getCustomer().getRole().getAccountId());
        return orderRepository.save(orderUpdate);
    }
}
