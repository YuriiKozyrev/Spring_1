package com.geekbrains.spring.mvc.repositories.specifications;
import com.geekbrains.spring.mvc.model.Goods;
import org.springframework.data.jpa.domain.Specification;

public class GoodsSpecifications {
    public static Specification<Goods> priceGEThan(int minPrice) {
        return (Specification<Goods>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Goods> priceLEThan(int maxPrice) {
        return (Specification<Goods>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

}