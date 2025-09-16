package com.product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Clase ExceptionResponse
 * Define los atributos que debe tener una excepción.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
public class ExceptionResponse {
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	private Integer status;
	private HttpStatus error;
	private String message;
	private String path;

	/**
	 * Obtiene la fecha y hora en que ocurrió el error.
	 * 
	 * @return objeto LocalDateTime con la fecha y hora del error
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Establece la fecha y hora en que ocurrió el error.
	 * 
	 * @param timestamp objeto LocalDateTime con la fecha y hora del error
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Obtiene el código de estado HTTP del error.
	 * 
	 * @return código de estado
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Establece el código de estado HTTP del error.
	 * 
	 * @param status código de estado
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Obtiene el tipo de error HTTP.
	 * 
	 * @return tipo de error
	 */
	public HttpStatus getError() {
		return error;
	}

	/**
	 * Establece el tipo de error HTTP.
	 * 
	 * @param error objeto HttpStatus con el tipo de error
	 */
	public void setError(HttpStatus error) {
		this.error = error;
	}

	/**
	 * Obtiene el mensaje descriptivo del error.
	 * 
	 * @return mensaje de error
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Establece el mensaje descriptivo del error.
	 * 
	 * @param message mensaje de error
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Obtiene la ruta del endpoint donde ocurrió el error.
	 * 
	 * @return ruta solicitada
	 */
	public String getPath() {
		return path;
	}
    
	/**
	 * Establece la ruta del endpoint donde ocurrió el error.
	 * 
	 * @param path ruta solicitada
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
