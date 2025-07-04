package com.prawin.order_service.dto;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url="http://product-service.product-service.aws:7894")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") int id);

    @GetMapping("/products")
    List<Product> getAllProducts();
}
