package com.manish.ProductService.service;

import com.manish.ProductService.model.ProductRequest;
import com.manish.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getById(long id);
}
