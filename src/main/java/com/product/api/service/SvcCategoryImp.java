package com.product.api.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.exception.ApiException;

/**
 * Clase SvcCategoryImp
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
@Service
public class SvcCategoryImp implements SvcCategory{

    // Para hacer uso de inyección de dependencias:
    @Autowired
    RepoCategory repo;

    /**
     * Obtiene la lista de todas las categorías almacenadas en la base de datos.
     * 
     * @return ResponseEntity con la lista de categorías y el estado HTTP OK
     * @throws ApiException si ocurre un error en la consulta a la base de datos
     */
    @Override
    public ResponseEntity<List<Category>> getCategories() {
        try {
            return new ResponseEntity<>(repo.getCategories(), HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error en la consulta de las categorías de la base de datos.");
        }
    

    }
    
}
