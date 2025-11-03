package com.product.commons.dto;

/**
 * Clase de ApiResponse, maneja las respuestas de los accesos de la api
 * @author Martínez Marcelo Ingrid Aylen
 * @author Pérez Evaristo Eris
 * @author Ramírez Venegas Alexa Paola
 */
public class ApiResponse {
    
	/**
	 * Mensaje de la ApiResponse
	 */
    private String message;

	/**
	 * Constructor de la ApiResponse
	 */
	public ApiResponse() {
		
	}

	/**
	 * Constructor del ApiResponse con el mensaje de la ApiResponse
	 * @param message mensaje del ApiResponse
	 */
	public ApiResponse(String message) {
		this.message = message;
	}

	/**
	 * Getter del mensaje de la ApiResponse
	 * @return regresa el mensaje en la ApiResponse
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter del mensaje en la ApiResponse
	 * @param message mensaje a poner en el ApiResponse
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
