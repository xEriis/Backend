package com.product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Clase RestExceptionHandler
 * Funciona como "manejador de excepciones”, extiende la clase ResponseEntityExceptionHandler para devolver
 * la excepción como un tipo ResponseEntity.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 * 			 Pérez Evaristo Eris
 * 			 Ramírez Venegas Alexa Paola
 * 
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    
	/**
	 * Método handleApiException(ApiException exception, WebRequest request)
	 * Maneja las excepciones de tipo ApiException.
	 * 
	 * @param exception excepción capturada
	 * @param request   objeto con información de la petición
	 * @return ResponseEntity con los detalles del error
	 */
    @ExceptionHandler(ApiException.class)
	protected ResponseEntity<ExceptionResponse> handleApiException(ApiException exception, WebRequest request){
        
		ExceptionResponse response = new ExceptionResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(exception.getStatus().value());
		response.setError(exception.getStatus());
		response.setMessage(exception.getMessage());
		response.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
		
		return new ResponseEntity<>(response, response.getError());
	}

	/**
	 * Método handleDBAccessException(DBAccessException exception, WebRequest request)
	 * Maneja las excepciones de tipo DBAccessException.
	 * 
	 * @param exception excepción capturada
	 * @param request   objeto con información de la petición
	 * @return ResponseEntity con los detalles del error
	 */
	@ExceptionHandler(DBAccessException.class)
	protected ResponseEntity<ExceptionResponse> handleDBAccessException(DBAccessException exception, WebRequest request){
		
		ExceptionResponse response = new ExceptionResponse();
		
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setError(HttpStatus.INTERNAL_SERVER_ERROR);
		response.setMessage("Error al acceder a la base de datos");
		response.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
		
		return new ResponseEntity<>(response, response.getError());
	}

}
