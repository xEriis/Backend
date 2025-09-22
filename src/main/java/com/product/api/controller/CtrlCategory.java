package com.product.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;

/**
 * Clase CtrlCategory
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */

@RestController
@RequestMapping("/category")
public class CtrlCategory {

    // Para hacer uso de inyección de dependencias
    @Autowired
    SvcCategory svc;

    /**
     * Método que regresa las categorías
     * @return categorías
     */
   @GetMapping
    public List<Category> getCategories(){
        return svc.getCategories();
    }
    
}
