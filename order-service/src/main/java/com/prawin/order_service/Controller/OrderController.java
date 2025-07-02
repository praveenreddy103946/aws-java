package com.prawin.order_service.Controller;

import com.prawin.order_service.dto.Order;
import com.prawin.order_service.dto.OrderResponse;
import com.prawin.order_service.dto.Product;
import com.prawin.order_service.dto.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private ProductClient productClient;

    @GetMapping("/orders")
    private List<OrderResponse> getAllOrders(){
        log.info("Inside get All orders method");
      List<Order> orders = new ArrayList<>();
        orders.addAll(Arrays.asList(
                new Order(1, 10, 1),
                new Order(2, 5, 2),
                new Order(3, 4, 3),
                new Order(4,7,1)
        ));

       return  orders.stream()
                .map(order->{
                    Product product = getProductById(order.getProduct_id());
                    int total_price = order.getQuantity()*product.getPrice();
                    return new  OrderResponse(order.getOrderId(),total_price,product);
                }).collect(Collectors.toList());

    }

    private Product getProductById(int id){
     log.info("calling get product by id method with product-id {}",id);
      return productClient.getProductById(id);
    }
}
