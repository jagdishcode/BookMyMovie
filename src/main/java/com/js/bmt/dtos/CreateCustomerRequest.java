package com.js.bmt.dtos;

import lombok.Data;

@Data
public class CreateCustomerRequest {
    private String name;
    private String email;
}