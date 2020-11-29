package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.entities.Order;
import com.geekbrains.july.market.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class RestOrdersController {
    private OrdersService ordersService;

    @Autowired
    public RestOrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

//    http://localhost:8189/market/api/v1/order
    @GetMapping
    public Order getAllProducts() {
        return ordersService.getOrder();
    }

//    http://localhost:8189/market/api/v1/order/add/4
    @GetMapping("/add/{id}")
    public Order addToOrder(@PathVariable Long id) {
        return ordersService.addToOrder(id);
    }

//    http://localhost:8189/market/api/v1/order/remove/4
    @GetMapping("/remove/{id}")
    public Order removeFromOrder(@PathVariable Long id) {
        return ordersService.removeFromOrder(id);
    }

}