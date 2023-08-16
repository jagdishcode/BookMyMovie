package com.js.bmt.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCustomerResponse {
    private String message;
    private Long id;
}
