
package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.exceptions.GoodsNotFoundException;
import com.geekbrains.spring.mvc.model.Goods;
import com.geekbrains.spring.mvc.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsService {

    private GoodsRepository goodsRepository;

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public List<Goods> getAll() {
        return goodsRepository.findAllByOrderByPriceAsc();
    }

    public Goods saveOrUpdate(Goods goods) {
        return goodsRepository.save(goods);
    }

    public Goods findById(Long id)  {
        return goodsRepository.findById(id).orElseThrow(() -> new GoodsNotFoundException("Can't found goods with id = " + id));
    }

    public Goods findByTitle(String title) {
        return goodsRepository.findOneByTitle(title);
    }

    public List<Goods> findByMinPrice(int minPrice) {
        return goodsRepository.findAllByPriceGreaterThan(minPrice);
    }

    public Page<Goods> findByPage(int pageNumber, int pageSize) {
        return goodsRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public Page<Goods> findAll(Specification<Goods> spec, Integer page, Sort.Direction sort) {
        if (page < 1L) {
            page = 1;
        }
        return goodsRepository.findAll(spec, PageRequest.of(page - 1, 5, Sort.by(sort, "price")));
    }


}