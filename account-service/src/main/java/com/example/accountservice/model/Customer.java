package com.example.accountservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
