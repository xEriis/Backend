package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

/**
 * Clase DtoProductImageIn
 * Dto para la entrada de imágenes de productos
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
public class DtoProductImageIn {
    @JsonProperty("product_id")
    @NotNull(message="El product_id es obligatorio")
    private Integer product_id;


    @JsonProperty("image")
    @NotNull(message="El image es obligatorio")
    private String image;

    /**
     * Setter para establecer el valor de product_id
     * @param product_id
     */
    public void setProduct_id(Integer product_id){
        this.product_id = product_id;
    }

    /**
     * Getter para obtener el valor de product_id
     * @return id del producto
     */
    public Integer getProduct_id(){
        return product_id;
    }

    /**
     * Setter para establecer el valor de image
     * @param image imagen del producto
     */
    public void setImage(String image){
        this.image = image;
    }

    /**
     * Getter para obtener el valor de image
     * @return imagen del producto
     */
    public String getImage(){
        return image;
    }
}
