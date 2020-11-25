package com.geekbrains.july.market.repositories.specifications;

import com.geekbrains.july.market.entities.Category;
import com.geekbrains.july.market.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> titleLike(String title_for_search) {
        String title_for_search_lower_case = title_for_search.toLowerCase();
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%".concat(title_for_search_lower_case).concat("%") );
    }

    public static Specification<Product> categoryLike(String category_for_search) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("category").get("title"), "%".concat(category_for_search).concat("%"));
    }
}
