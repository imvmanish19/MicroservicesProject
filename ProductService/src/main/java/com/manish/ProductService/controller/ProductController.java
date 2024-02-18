package com.manish.ProductService.controller;

import com.manish.ProductService.entity.Product;
import com.manish.ProductService.model.ProductRequest;
import com.manish.ProductService.model.ProductResponse;
import com.manish.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) {
        ProductResponse productResponse = productService.getById(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
