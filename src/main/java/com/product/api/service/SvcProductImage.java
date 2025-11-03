package com.product.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.entity.ProductImage;
import com.product.common.dto.ApiResponse;

public interface SvcProductImage {

    /**
     * Método para actualizar o crear la imagen de un producto
     * @param in dto con los datos necesario para actualizar o crear la imagen de un producto
     * @return APIResponse con el resultado de la operación
     */
    public ResponseEntity<ApiResponse> uploadProductImage(DtoProductImageIn in);

    /**
     * Método para borrar la imagen de un producto solicitado
     * @param id id del producto con imagen a borrar
     * @param product_image_id id de la imagen a borrar
     * @return APIResponse con el resultado de la operación
     */
    public ResponseEntity<ApiResponse> deleteProductImage(Integer id, Integer product_image_id);

    /**
     * Método para obtener las imagenes asociadas a un producto
     * @param id id del producto a obtener las imágenes
     * @return Lista con las imagenes del producto solicitado
     */
    public ResponseEntity<List<ProductImage>> getProductImages(Integer id);
}
