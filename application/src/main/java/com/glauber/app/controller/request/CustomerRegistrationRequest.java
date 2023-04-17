package com.glauber.app.controller.request;

import com.glauber.app.entity.Address;
import java.util.ArrayList;
import java.util.List;

public class CustomerRegistrationRequest {
    public Long id;
    public String name;
    public String email;
    public List<Address> address = new ArrayList<>();
}