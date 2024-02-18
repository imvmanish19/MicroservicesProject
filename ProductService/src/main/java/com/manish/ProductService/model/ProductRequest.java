package com.manish.ProductService.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private String price;
    private String quantity;
}
