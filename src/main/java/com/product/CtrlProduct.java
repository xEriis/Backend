package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase CtrlProduct
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */

@RestController
public class CtrlProduct {

    @GetMapping("/category")
    public Category[] getCategories() {
        Category[] categories = {
            new Category(1, "Lentes", "Lts", 1),
            new Category(2, "Relojes", "Rljs", 1),
            new Category(3, "Anillos", "Anl", 1),
            new Category(4, "Pulseras", "Pls", 1)
        };
        return categories;
    }
    
}
