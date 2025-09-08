package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Category;

    /**
     * Interfaz RepoCategory
     * 
     * @author Martínez Marcelo Ingrid Aylen
     *         Pérez Evaristo Eris
     *         Ramírez Venegas Alexa Paola
     */
    @Repository
    public interface RepoCategory extends JpaRepository<Category, Integer> {

        @Query(value ="SELECT * FROM category ORDER BY category_id", nativeQuery = true)
        // Método getCategories (consulta categorías registradas en la bd utilizando JPA)
        List<Category> getCategories();

        
    } 
    
