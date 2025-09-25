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

        /**
         * Método findActive, consulta todas las categorías activas en la base de datos
         * @return regresa las categorías activas
         */
        @Query(value ="SELECT * FROM category WHERE status = 1 ORDER BY category", nativeQuery = true)
        List<Category> findActive();
        
        /**
         * Método findByStatus, busca las categorías con un status dado
         * @param status status de las categorías a buscar
         * @return regresa las categorías con el status solicitado
         */
        List<Category> findByStatus(Integer status);
        
        /**
         * Método findByStatusOrderByCategoryAsc, consulta las categorías con el status dado y las ordena de forma ascendente
         * @param status status a buscar en las categorías
         * @return regresa las categorías dado un status ordenadas de forma ascendente
         */
        List<Category> findByStatusOrderByCategoryAsc(Integer status);

        /**
         * Método getCategories (consulta categorías registradas en la bd utilizando JPA)
         * @return regresa las categorías encontradas en la bd
         */
       @Query(value ="SELECT * FROM category ORDER BY category_id", nativeQuery = true)
        List<Category> getCategories();

        /**
         * Método findAll, obtiene todas las categorías en la base de datos
         */
        @Query(value ="SELECT * FROM category ORDER BY category", nativeQuery = true)
	    List<Category> findAll();
        
        /**
         * Método create, crea una nueva categoría en la base de datos
         * @param category nombre de la categoría a crear
         * @param tag tag de la categoría a crear
         */
        @Modifying(clearAutomatically = true, flushAutomatically = true)
        @Transactional
        @Query(value = "INSERT INTO category(category, tag, status) VALUES (:category, :tag, 1);", nativeQuery = true)
        void create(@Param("category") String category, @Param("tag") String tag);
        
        /**
         * Método update, (consulta categorías registradas en la bd utilizando JPA)
         * @param category_id id de la categoría a actualizar
         * @param category categoría a actualizar
         * @param tag tag de la categoría a consultar
         */
        @Modifying(clearAutomatically = true, flushAutomatically = true)
        @Transactional
        @Query(value ="UPDATE category SET category = :category, tag = :tag WHERE category_id = :category_id", nativeQuery = true)
        void update(@Param("category_id") Integer category_id, @Param("category") String category, @Param("tag") String tag);

        /**
         * Método update status (consulta categorías registradas en la bd utilizando JPA)
         * @param category_id id de la category a actualizar el status
         * @param status status a manejar, ya sea 1 para activar o 0 para desactivar 
         */
        @Modifying(clearAutomatically = true, flushAutomatically = true)
        @Transactional
        @Query(value ="UPDATE category SET status = :status WHERE category_id = :category_id", nativeQuery = true)
        void updateStatus(@Param("category_id") Integer category_id, @Param("status") Integer status);
    } 
    
