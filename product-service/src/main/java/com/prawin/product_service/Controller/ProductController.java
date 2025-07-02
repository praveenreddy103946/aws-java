package com.prawin.product_service.Controller;

import com.prawin.product_service.dto.Product;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/product-service")
@Slf4j
public class ProductController {

    @GetMapping("/products")
    private List<Product> getAllProducts(){
       log.info("Inside get All products method");
       List<Product> products = Arrays.asList(
               new Product(1,5000,"Iphone"),
               new Product(2,1000,"Air Buds"),
               new Product(3,2000,"Watch")
       );

       return products;
    }

    @GetMapping("/products/{id}")
    private Product getProductById(@PathVariable(name="id") int id){
        log.info("inside get product by id method");

        List<Product> products = Arrays.asList(
                new Product(1,5000,"Iphone"),
                new Product(2,1000,"Air Buds"),
                new Product(3,2000,"Watch")
        );

     return    products.stream()
                .filter(p->p.getProduct_id()==id)
                .findFirst()
                .orElseGet(()->{
                    log.error("No Product found with id {}",id);
                    return null;
                });
    }

}
