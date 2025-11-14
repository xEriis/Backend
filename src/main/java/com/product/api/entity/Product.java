package com.product.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer product_id;
	
	@Column(name = "gtin")
	private String gtin;

	@Column(name = "product")
	private String product;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Float price;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "category_id")
	private Integer category_id;

	@Column(name = "status")
	private Integer status;

	/**
	 * Getter del product_id de un producto
	 * @return product_id de un producto
	 */
	public Integer getProduct_id() {
		return product_id;
	}

	/**
	 * Setter del product_id de un producto
	 * @param product_id id del producto a escribir
	 */
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	/**
	 * Getter del gtin de un producto
	 * @return gtin del producto
	 */
	public String getGtin() {
		return gtin;
	}

	/**
	 * Setter del gtin de un producto
	 * @param gtin gtin del producto a escribir
	 */
	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	/**
	 * Getter del nombre de un producto
	 * @return nombre del producto
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * Setter del nombre de un producto
	 * @param product nombre del producto a escribir
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
	 * @param description descripción del producto a escribir
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
	 * @param price precio del producto a escribir
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * Getter del stock de un producto
	 * @return stock del producto
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * Setter del stock de un producto
	 * @param stock stock del producto a escribir
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * Getter de la categoría a la que pertenece un producto
	 * @return categoría del producto
	 */
	public Integer getCategory_id() {
		return category_id;
	}

	/**
	 * Setter de la categoría a la que pertenece un producto
	 * @param category_id categoría del producto a escribir
	 */
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	/**
	 * Getter del status de un producto
	 * @return status del producto
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Setter del status de un producto
	 * @param status status del producto a escribir
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
