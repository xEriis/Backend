package com.product.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;

/**
 * Clase CtrlCategory
 * Controlador con los endpoints relacionados con la gestión
 * de categorías.
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
     * Endpoint que regresa las categorías
     * 
     * @return ResponseEntity con la lista de categorías
     */
   @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        return svc.getCategories();
    }
    
}
