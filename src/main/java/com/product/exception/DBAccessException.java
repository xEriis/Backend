package com.product.exception;

import org.springframework.dao.DataAccessException;

/**
 * Clase DBAAccesException
 * Cuenta con los parámetros necesarios y extienda la clase Exception para
 * poder lanzar la excepción.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
public class DBAccessException extends Exception{
    private static final long serialVersionUID = 1L;
	private DataAccessException exception;
	
	/**
	 * Constructor de DBAccesException
	 * @param e excepción a arrojar
	 */
	public DBAccessException(DataAccessException e) {
		this.exception = e;
	}

	/**
	 * Getter de la excepción
	 * @return regresa la excepción 
	 */
	public DataAccessException getException() {
		return exception;
	}

	/**
	 * Setter de la excepción
	 * @param exception excepción a colocar
	 */
	public void setException(DataAccessException exception) {
		this.exception = exception;
	}

	/**
	 * Getter para la Serial version uid
	 * @return regresa la serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
