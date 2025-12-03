package com.product.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

/**
 * Clase category
 * @author Martínez Marcelo Ingrid Aylen
 *          Pérez Evaristo Eris
 *          Ramírez Venegas Alexa Paola
 */

@Entity
@Table(name = "category")
public class Category {
    
    /* Anotaciones */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("category_id")
	@Column(name = "category_id")
    private Integer category_id;

    @JsonProperty("category")
	@Column(name = "category")
    private String category;

    @JsonProperty("tag")
	@Column(name = "tag")
    private String tag;

    @JsonProperty("status")
	@Column(name = "status")
    private Integer status;

    /**
     * Constructor vacío
     */
    public Category() {
        
    }

    /**
     * Constructor 
     * 
     * @param category_id   id de la categoría        
     * @param category      nombre de la categoría
     * @param tag           tag de la categoría
     * @param status        status de la categoría
     */
    public Category(Integer category_id, String category, String tag, Integer status) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }

    /**
     * Método getCategory_id()
     * 
     * @return el id de la categoría
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * Método getCategory()
     * 
     * @return el nombre de la categoría
     */
    public String getCategory() {
        return category;
    }

    /**
     * Método getTag()
     * 
     * @return el tag de la categoría
     */
    public String getTag() {
        return tag;
    }

    /**
     * Método getStatus()
     * 
     * @return el estatus de la categoría
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Método setId(Integer new_id)
     * 
     * @param new_id el nuevo id de la categoría
     */
    public void setId(Integer new_id) {
        this.category_id = new_id;
    }

    /**
     * Método setName(String new_name)
     * 
     * @param new_name el nuevo nombre de la categoría
     */
    public void setName(String new_name) {
        this.category = new_name;
    }

    /**
     * Método setTag(String new_tag)
     * 
     * @param new_tag el nuevo tag de la categoría
     */
    public void setTag(String new_tag) {
        this.tag = new_tag;
    }

    /**
     * Método setStatus(Integer new_status)
     * 
     * @param new_status el nuevo estatus de la categoría
     */
    public void setStatus(Integer new_status) {
        this.status = new_status;
    }

    /**
     * Regresa la representación en cadena de una categoría.
     * 
     * @return la cadena que representa a una categoría.
     */
    @Override
    public String toString() {
        return "[" + category_id + ", " + category + ", " + tag + ", " + status + "]";
    }
}
