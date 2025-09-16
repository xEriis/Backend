package com.product.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.entity.Category;

/**
 * Interfaz SvcCategory
 * Define los métodos relacionados con la gestión de categorías
 * que deben implementarse en la capa de servicio.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
public interface SvcCategory {

    /**
     * Obtiene la lista de todas las categorías.
     * 
     * @return ResponseEntity que contiene la lista de categorías
     */
    public ResponseEntity<List<Category>> getCategories();

}
