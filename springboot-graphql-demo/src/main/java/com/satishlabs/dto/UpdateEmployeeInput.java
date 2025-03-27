package com.satishlabs.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeInput {
    private Long id;
    private String name;
    private String email;
    private String department;
}

