package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Goods;
import com.geekbrains.spring.mvc.repositories.specifications.GoodsSpecifications;
import com.geekbrains.spring.mvc.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/goods")
public class GoodsController {
    private GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping
    public String showAllGoods(Model model,
                               @RequestParam(name = "p", defaultValue = "1") Integer pageNumber,
                               @RequestParam(name = "min_price", required = false) Integer minPrice,
                               @RequestParam(name = "max_price", required = false) Integer maxPrice,
                               @RequestParam(name = "sort", defaultValue = "ASC") Sort.Direction sort) {
        Specification<Goods> spec1 = Specification.where(null);
        if (minPrice != null) {
            spec1 = spec1.and(GoodsSpecifications.priceGEThan(minPrice));
        }
        if (maxPrice != null) {
            spec1 = spec1.and(GoodsSpecifications.priceLEThan(maxPrice));
        }

//        http://localhost:8189/app/goods/?sort=DESC
        List<Goods> goods = goodsService.findAll(spec1, pageNumber, sort).getContent();
        model.addAttribute("goods", goods);
        return "all_goods";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_goods_form";
    }

    @PostMapping("/add")
    public String saveNewGood(@ModelAttribute Goods newGood) {
        goodsService.saveOrUpdate(newGood);
        return "redirect:/goods/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("goods", goodsService.findById(id));
        return "edit_goods_form";
    }

    @PostMapping("/edit")
    public String modifyGood(@ModelAttribute Goods modifiedGood) {
        goodsService.saveOrUpdate(modifiedGood);
        return "redirect:/goods/";
    }

    @GetMapping("/info_by_title")
    @ResponseBody
    public Goods infoByTitle(@RequestParam String title) {
        return goodsService.findByTitle(title);
    }

//    @GetMapping("/info_by_price")
//    @ResponseBody
//    public Goods infoByPrice(@RequestParam String price) {
//        return goodsService.findByPrice(price);
//    }

    @GetMapping("/find_by_min_price")
    @ResponseBody
    public List<Goods> findGoodsByMinPrice(@RequestParam int price) {
        return goodsService.findByMinPrice(price);
    }

    @GetMapping("/sort")
    @ResponseBody
    public List<Goods> findAllSortByPrice() {
        return goodsService.getAll();
    }

}
