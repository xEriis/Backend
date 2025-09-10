package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;

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
     * Regresa directamente lo que devuelve el método getCategories() del repositorio
     */
    @Override
    public List<Category> getCategories() {
        return repo.getCategories();

    }
    
}
