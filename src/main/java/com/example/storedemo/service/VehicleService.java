package com.example.storedemo.service;

import com.example.storedemo.entity.Vehicle;
import com.example.storedemo.repository.CustomerRepository;
import com.example.storedemo.repository.OrderRepository;
import com.example.storedemo.repository.RoleRepository;
import com.example.storedemo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }
    public Vehicle findVehicleByID(int id){
        return vehicleRepository.findById(id).get();
    }
    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
    public String deleteVehicle(int id){
        vehicleRepository.deleteById(id);
        return "removed vehicle id = "+id;
    }
    public Vehicle updateVehicle(Vehicle vehicle){
        Vehicle updateVehicle = vehicleRepository.findById(vehicle.getVehicleId()).get();
        updateVehicle.setColor(vehicle.getColor());
        updateVehicle.setType(vehicle.getType());
        updateVehicle.getCustomer().setAge(vehicle.getCustomer().getAge());
        updateVehicle.getCustomer().setName(vehicle.getCustomer().getName());
        updateVehicle.getCustomer().setSdt(vehicle.getCustomer().getSdt());
        updateVehicle.getCustomer().setCity(vehicle.getCustomer().getCity());
        updateVehicle.getCustomer().getRole().setRole(vehicle.getCustomer().getRole().getRole());
        updateVehicle.getCustomer().getRole().setAccountId(vehicle.getCustomer().getRole().getAccountId());
        updateVehicle.getCustomer().getRole().setPassword(vehicle.getCustomer().getRole().getPassword());
        updateVehicle.getCustomer().getRole().setUserName(vehicle.getCustomer().getRole().getUserName());
        return updateVehicle;
    }
}
