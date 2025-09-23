package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Category;

import jakarta.transaction.Transactional;

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

        @Query(value ="SELECT * FROM category ORDER BY category", nativeQuery = true)
	    List<Category> findAll();

        @Query(value ="SELECT * FROM category WHERE status = 1 ORDER BY category", nativeQuery = true)
        List<Category> findActive();
        
        List<Category> findByStatus(Integer status);
        
        List<Category> findByStatusOrderByCategoryAsc(Integer status);

        @Modifying(clearAutomatically = true, flushAutomatically = true)
        @Transactional
        @Query(value = "INSERT INTO category(category, tag, status) VALUES (:category, :tag, 1);", nativeQuery = true)
        void create(@Param("category") String category, @Param("tag") String tag);
            
    } 
    
