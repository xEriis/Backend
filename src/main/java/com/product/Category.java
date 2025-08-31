package com.product;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Clase Category
 * @author  Martínez Marcelo Ingrid Aylen
 *          Pérez Evaristo Eris
 *          Ramírez Venegas Alexa Paola
 */
@JsonPropertyOrder({"id", "category", "tag", "status"})
public class Category{

    // Atributos
    private int category_id;
    private String category;
    private String tag;
    private int status;

    /**
     * Constructor de la clase Category
     */
    public Category(int category_id, String category, String tag, int status){
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }

    /**
     * Método getId()
     * 
     * @return el id de la categoría
     */
    public int getId(){
        return category_id;
    }

    /**
     * Método getCategory()
     * 
     * @return el nombre de la categoría
     */
    public String getCategory(){
        return category;
    }

    /**
     * Método getTag()
     * 
     * @return el tag de la categoría
     */
    public String getTag(){
        return tag;
    }

    /**
     * Método getStatus()
     * 
     * @return el estatus de la categoría
     */
    public int getStatus(){
        return status;
    }

    /**
     * Método setId(int new_id)
     * 
     * @param new_id el nuevo id de la categoría
     */
    public void setId(int new_id) {
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
     * Método setStatus(int new_status)
     * 
     * @param new_status el nuevo estatus de la categoría
     */
    public void setStatus(int new_status) {
        this.status = new_status;
    }

    @Override
    public String toString() {
        return "[" + category_id + ", " + category + ", " + tag + ", " + status + "]";
    }
}