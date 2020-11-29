package com.geekbrains.july.market.repositories;

import com.geekbrains.july.market.entities.Order;
import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class OrdersRepository {
    private Order order;
    private List<Product> products;
    private ProductsService productsService;

    @Autowired
    public void setProductsServise(ProductsService productsServise) {
        this.productsService = productsServise;
    }

    @PostConstruct
    public void init() {

        this.products = new ArrayList<>();
        this.products.add(productsService.findById(1L));
        this.products.add(productsService.findById(2L));

        this.order = new Order(1L, products);
    }

    public Order findAll() {
        return order;
    }

    public Order addToOrder(Long productId) {
        order.getOrder().add(productsService.findById(productId));
        return order;
    }

    public Order removeFromOrder(Long productId) {
        for (int i = 0; i < order.getOrder().size(); i++) {
            if(order.getOrder().get(i).getId().equals(productId)) {
                order.getOrder().remove(i);
            }
        }
        return order;
    }
}
