package com.glauber.app.service;

import com.glauber.app.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }
    public List<Customer> getAllUsers() {

        return customerRepository.findAll();
    }
    public Customer createClient(Customer customer){

        return customerRepository.save(customer);
    }
    public Customer updateClient(Customer customer, Long clientId){
        Customer customerUpdated = customerRepository.findById(clientId).orElseThrow();
        customerUpdated.setName(customer.getName());
        customerUpdated.setEmail(customer.getEmail());
        customerUpdated.setAddress(customer.getAddress());
        return customerRepository.save(customerUpdated);
    }
    public void deleteClient(Long clientId){

        customerRepository.deleteById(clientId);
    }
}
