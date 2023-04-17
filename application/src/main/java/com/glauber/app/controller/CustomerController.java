package com.glauber.app.controller;

import com.glauber.app.controller.converter.CustomerRequestConverter;
import com.glauber.app.controller.request.CustomerRegistrationRequest;
import com.glauber.app.controller.response.CustomerRegistrationResponse;
import com.glauber.app.entity.Customer;
import com.glauber.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRequestConverter converter;

    @PostMapping
    public ResponseEntity<CustomerRegistrationResponse> createClient(@RequestBody CustomerRegistrationRequest request) {
        Customer createCustomer = customerService.createClient(
                converter.toClientEntity(request)
        );
        return new ResponseEntity<>(converter.toResponse(createCustomer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerRegistrationResponse>> getAllClients() {
        List<Customer> customers = customerService.getAllUsers();
        return new ResponseEntity<>(converter.toResponse(customers), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerRegistrationResponse> updateClient(
            @PathVariable("id") Long clientId, @RequestBody CustomerRegistrationRequest request) {
        Customer updateCustomer = customerService.updateClient(converter.toClientEntity(request), clientId);
        return new ResponseEntity<>(converter.toResponse(updateCustomer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long clientId) {
        customerService.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}