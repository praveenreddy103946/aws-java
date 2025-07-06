package com.prawin.order_service.dto;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url="http://product-service-lb-1886046701.eu-north-1.elb.amazonaws.com/product-service")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") int id);

    @GetMapping("/products")
    List<Product> getAllProducts();
}
