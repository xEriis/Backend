package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


/**
 * Clase DtoProductIn
 * Dto para la entrada de productos.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
public class DtoProductIn {

	@JsonProperty("gtin")
	@Pattern(regexp = "^\\+?\\d{13}$", message = "El gtin tiene un formato inválido")
	@NotNull(message="El gtin es obligatorio")
	private String gtin;
	
	@JsonProperty("product")
	@NotNull(message="El product es obligatorio")
	private String product;
	
	@JsonProperty("description")
	@NotNull(message="El description es obligatorio")
	private String description;
	
	@JsonProperty("price")
	@Min(value = 0)
	@NotNull(message="El price es obligatorio")
	private Float price;
	
	@JsonProperty("stock")
	@NotNull(message="El stock es obligatorio")
	private Integer stock;

	@JsonProperty("category_id")
	@NotNull(message="El category_id es obligatorio")
	private Integer category_id;

	/**
	 * Getter del gtin
	 * @return gtin del producto
	 */
	public String getGtin() {
		return gtin;
	}

	/**
	 * Setter del gtin
	 * @param gtin gtin del producto
	 */
	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	/**
	 * Getter del product
	 * @return nombre del producto
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * Setter del product
	 * @param product nombre del producto
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * Getter de la descripción
	 * @return descripción del producto
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter de la descripción
	 * @param description descripción del producto
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter del price
	 * @return precio del producto
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * Setter del price
	 * @param price precio del producto
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * Getter del stock
	 * @return stock del producto
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * Setter del stock
	 * @param stock stock del producto
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * Getter del category_id
	 * @return category_id del producto
	 */
	public Integer getCategory_id() {
		return category_id;
	}

	/**
	 * Setter del category_id
	 * @param category_id category_id del producto
	 */
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
}
