package com.js.bmt.controller;

import com.js.bmt.dtos.CreateCustomerRequest;
import com.js.bmt.dtos.CreateCustomerResponse;
import com.js.bmt.models.Customer;
import com.js.bmt.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/bmt/v1")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    @PostMapping(path = "/customers")
    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request){
        System.out.println("Recieved a request for creating customer");
        System.out.println(request.toString());
        Customer customer = customerService.signUp(request.getName(), request.getEmail(), request.getPassword());
        return new CreateCustomerResponse("OK", customer.getId());
    }
}
