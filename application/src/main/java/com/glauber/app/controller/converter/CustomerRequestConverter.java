package com.glauber.app.controller.converter;

import com.glauber.app.controller.request.CustomerRegistrationRequest;
import com.glauber.app.controller.response.CustomerRegistrationResponse;
import com.glauber.app.entity.Customer;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerRequestConverter {
    public Customer toClientEntity(CustomerRegistrationRequest request){
        Customer customer = new Customer();
        customer.setId(request.id);
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAddress(request.address);
        return customer;
    }
    public List<CustomerRegistrationResponse>  toResponse(List<Customer> customers){
        List<CustomerRegistrationResponse> clientsResponse = new ArrayList<>();
        for(var customer : customers){
            clientsResponse.add(toResponse(customer));
        }
        return clientsResponse;
    }
    public CustomerRegistrationResponse toResponse(Customer customer) {
        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        response.id = customer.getId();
        response.name = customer.getName();
        response.email = customer.getEmail();
        response.address = customer.getAddress();
        return response;
    }
}