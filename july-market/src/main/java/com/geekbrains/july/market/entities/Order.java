package com.geekbrains.july.market.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Order {

    private Long orderId;
    private List<Product> order;

    public Order (Long orderId, List<Product> order){
        this.orderId = orderId;
        this.order = order;
    }
}
