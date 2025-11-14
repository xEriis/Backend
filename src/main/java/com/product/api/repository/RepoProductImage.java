package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.product.api.entity.ProductImage;

import jakarta.transaction.Transactional;

@Repository
public interface RepoProductImage extends JpaRepository<ProductImage, Integer> {
    
    /**
     * Método findByProduct_id encuentra las imagenes de los productos activos en la base de datos
     * @param product_id producto activo a encontrar en la base de datos
     * @return Lista de los productos activos
     */
    @Query(value = "SELECT * FROM product_image WHERE product_id = :product_id AND status = 1;", nativeQuery = true)
    List<ProductImage> findByProduct_id(Integer product_id);

    /**
     * Método findProductId, encuentra las imagenes asociadas a un producto determinado en la base de datos
     * @param product_id producto a buscar sus imagenes
     * @return lista con las imagenes de dicho producto
     */
    @Query(value = "SELECT * FROM product_image WHERE product_id = :product_id;", nativeQuery = true)
    List<ProductImage> findByProductId(Integer product_id);

    /**
     * Método disableProductImage, desactiva un producto cambiando su status a 0 en la base de datos
     * @param product_image_id id de la imagen a borrar
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE product_image SET status = 0 WHERE product_image_id = :product_image_id;", nativeQuery = true)
    void disableProductImage(Integer product_image_id);
}

