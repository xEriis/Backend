package com.product.exception;

import org.springframework.http.HttpStatus;

/**
 * Clase ApiException
 * Cuenta con los parámetros necesarios y extienda la clase RuntimeException para
 * poder lanzar la excepción.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus status;

    /**
     * Constructor
     * 
     * @param status  código de estado HTTP
     * @param message mensaje descriptivo del error
     */
    public ApiException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }

    /**
     * Método getSerialversionuid()
     * Obtiene el identificador de serialización.
     * 
     * @return serialVersionUID
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Método getStatus()
     * Obtiene el HttpStatus asociado a la excepción.
     * 
     * @return estado HTTP
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Método setStatus(HttpStatus status)
     * Establece el HttpStatus de la excepción.
     * 
     * @param status nuevo estado HTTP
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
