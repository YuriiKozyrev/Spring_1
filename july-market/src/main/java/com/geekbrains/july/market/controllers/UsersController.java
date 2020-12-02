package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.entities.Category;
import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.entities.User;
import com.geekbrains.july.market.repositories.specifications.ProductSpecifications;
import com.geekbrains.july.market.services.CategoriesService;
import com.geekbrains.july.market.services.ProductsService;
import com.geekbrains.july.market.services.UsersService;
import com.geekbrains.july.market.utils.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/profile/user")
public class UsersController {
    private UsersService usersService;
    private CategoriesService categoriesService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String showUserProfile(Model model, Principal principal){
        Optional<User> user = usersService.findByPhone(principal.getName());
//        UserDetails user = usersService.loadUserByUsername(principal.getName());
        model.addAttribute("user",user);
        return "user_profile";
    }

}