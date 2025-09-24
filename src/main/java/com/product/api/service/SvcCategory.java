package com.product.api.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.commons.dto.ApiResponse;
import com.product.exception.DBAccessException;


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

    public ResponseEntity<List<Category>> getCategories();
    public List<Category> findAll() throws DBAccessException;
    public List<Category> findActive();
    public ApiResponse create(DtoCategoryIn in);
    public ApiResponse update(DtoCategoryIn in, Integer id);
    public ApiResponse enable(Integer id);
    public ApiResponse disable(Integer id);

}
