package com.product.api.dto.out;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "product")
public class DtoProductOut {

	@Id
    private Integer product_id;
    
	private String gtin;
	private String product;
	private String description;
	private Float price;
	private Integer stock;
	private String category;
    @Transient
    private List<String> image;

    /**
     * Getter del product_id del producto 
     * @return product_id solictado
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * Setter del product_id, escribe el id solicitado
     * @param product_id id del producto
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * Getter del gtin del producto 
     * @return gtin solictado
     */
    public String getGtin() {
        return gtin;
    }

    /**
     * Setter del gtin, escribe el gtin solicitado
     * @param gtin gtin del producto
     */
    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    /**
     * Getter del nombre del producto 
     * @return nombre del producto
     */
    public String getProduct() {
        return product;
    }

    /**
     * Setter del nombre del producto
     * @param product nombre a escribir al producto
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Getter de la descripción de un producto
     * @return descripción del producto
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter de la descripción de un producto
     * @param description descripción a escribir en el producto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter del precio de un producto
     * @return precio del producto
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Setter del precio de un producto
     * @param price precio a escribir en el producto
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Getter del stock de un producto 
     * @return stock del producto solicitado
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Setter del stock de un producto
     * @param stock stock a escribir del producto
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Getter de la categoría a la que pertenece un producto
     * @return categoría del producto
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter de la categoría de un producto
     * @param category categoría a escribir de un producto
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter de las imagenes de un productos
     * @return lista con las imagenes de un producto
     */
    public List<String> getImage() {
        return image;
    }

    /**
     * Setter de las imagenes de un producto
     * @param image imagen a agregar a un producto
     */
    public void setImage(List<String> image) {
        this.image = image;
    }

    
}
