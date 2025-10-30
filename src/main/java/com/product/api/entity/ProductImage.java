package com.product.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;



/*  Creamos la entidad, se usa notaciones JPA para mapear a la base de datos  */
@Entity
@Table(name = "product_image")
public class ProductImage{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Integer product_image_id;

    @Column(name = "product_id")
    private Integer product_id;


    @Column(name = "image")
    private String image;


    @Column(name = "status")
    private Integer status; 

    public ProductImage(){

    }

    /**
     * Metodo para establecer el valor de product_image_id
     * @param product_image_id
     */
    public void setProduct_image_id(Integer product_image_id){
        this.product_image_id = product_image_id;
    }

    /**
     * Método para obtener el valor de product_image_id
     * @return
     */
    public Integer getProduct_image_id(){
        return product_image_id;
    }

    /**
     * Método para establecer el valor de product_id
     * @param product_id
     */
    public void setProduct_id(Integer product_id){
        this.product_id = product_id;
    }

    /**
     * Método para obtener el valor de product_id
     * @return
     */
    public Integer getProduct_id(){
        return product_id;
    }

    /**
     * Método para establecer el valor de image
     * @param image
     */
    public void setImage(String image){
        this.image = image;
    }

    /**
     * Método para obtener el valor de image
     * @return
     */
    public String getImage(){
        return image;
    }

    /**
     * Método para establecer el status
     * @param status
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * Método para obtener el status
     * @return
     */
    public Integer getStatus(){
        return status;
    }

}
