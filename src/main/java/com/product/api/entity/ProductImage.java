package com.product.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


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

    public void setProduct_image_id(Integer product_image_id){
        this.product_image_id = product_image_id;
    }

    public Integer getProduct_image_id(){
        return product_image_id;
    }

    public void setProduct_id(Integer product_id){
        this.product_id = product_id;
    }

    public Integer getProduct_id(){
        return product_id;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return status;
    }

}
