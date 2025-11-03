package com.product.api.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoProductListOut {
	
	@JsonProperty("product_id")
	private Integer product_id;
	
	@JsonProperty("gtin")
	private String gtin;

	@JsonProperty("product")
	private String product;

	@JsonProperty("price")
	private Float price;

	@JsonProperty("status")
	private Integer status;

	/**
	 * Contructor del DtoListOut para un producto
	 * @param product_id id del producto
	 * @param gtin gtin del producto 
	 * @param product nombre del producto
	 * @param price precio del producto
	 * @param status status del producto
	 */
	public DtoProductListOut(Integer product_id, String gtin, String product, Float price, Integer status) {
		super();
		this.product_id = product_id;
		this.gtin = gtin;
		this.product = product;
		this.price = price;
		this.status = status;
	}

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
	 * @return nombre del producto solictado
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * Setter del producto, escribe el nombre solicitado
	 * @param product nombre del producto
	 */
	public void setProduct(String product) {
		this.product = product;
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
	 * @param price precio a escribir del producto solicitado
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * Getter del status del producto
	 * @return status del producto solicitado
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Setter del status de un producto
	 * @param status status a escribir en el producto solicitado
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}