package com.manish.ProductService.service.impl;

import com.manish.ProductService.entity.Product;
import com.manish.ProductService.error.ProductException;
import com.manish.ProductService.model.ProductRequest;
import com.manish.ProductService.model.ProductResponse;
import com.manish.ProductService.repository.ProductRepository;
import com.manish.ProductService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        Product productEntity = Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        log.info("Adding product!!");
        Product product = productRepository.save(productEntity);
        log.info("Product added, {}", product.getId());
        return product.getId();
    }

    @Override
    public ProductResponse getById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Product with id: "+id+" not found", HttpStatus.NOT_FOUND.value(),"PRODUCT_NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
