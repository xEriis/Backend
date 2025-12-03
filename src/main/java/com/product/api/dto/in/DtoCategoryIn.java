package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * Clase DtoCategoryIn
 * Dto para pasar los datos entre el user y el server.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */

public class DtoCategoryIn {


	/**
	 * Atributos que recibe la API para registrar/actualizar una categoría
	 */
	@JsonProperty("category")
	@NotNull(message="La categoria es obligatoria")
	private String category;
		
	@JsonProperty("tag")
	@NotNull(message="El tag es obligatorio")
	private String tag;

	/**
	 * Getter para la categoría del dto
	 * @return regresa la categoría del dto
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Setter de la categoría en el dto
	 * @param category categoría del dto
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Getter del tag en el dto
	 * @return tag del dto
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Setter del tag del dto
	 * @param tag tag del dto
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
}