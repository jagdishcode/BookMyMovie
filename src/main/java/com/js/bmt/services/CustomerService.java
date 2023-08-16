package com.js.bmt.services;

import com.js.bmt.models.Customer;
import com.js.bmt.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    public Customer signUp(String name, String email){
        System.out.println("Service layer called for creating customer");


        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setBookings(new ArrayList<>());
        System.out.println(customer.toString());
        //call the reporistory and try ti save that to DB
        customerRepository.save(customer);
        return customer;
    }
}
