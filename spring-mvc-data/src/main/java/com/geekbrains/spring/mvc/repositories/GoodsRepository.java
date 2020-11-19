package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsRepository extends JpaRepository <Goods, Long>, JpaSpecificationExecutor<Goods> {
    Goods findOneByTitle(String title);
    List<Goods> findAllByPriceGreaterThan(int minPrice);
    List<Goods> findAllByOrderByPriceAsc();
}
