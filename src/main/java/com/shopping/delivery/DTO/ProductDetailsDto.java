package com.shopping.delivery.DTO;


import lombok.Data;

@Data
public class ProductDetailsDto {

    private Long Id;

    private String product;

    private String description;

    private double price;

    private Long quantity;
}
