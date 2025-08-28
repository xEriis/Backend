package com.product;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/category")
public class CtrlProduct {

    @GetMapping
    public List<Category> getCategories() {
        Categorias categoriesContainer = new Categorias();
        Category a = new Category(1, "Lentes", "Lts", 1);
        Category b = new Category(2, "Relojes", "Rljs", 1);
        categoriesContainer.createCategory(a);
        categoriesContainer.createCategory(b);
        
        return Arrays.asList(a, b);
    }
}

