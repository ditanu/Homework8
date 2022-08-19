package com.example.Homework7.model;

import lombok.Data;

@Data
public class CreateProductRequest {
    private ProductType type;
    private String name;
    private String identificationCode;
}
