package com.product.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;
import com.product.commons.dto.ApiResponse;
import com.product.exception.DBAccessException;

import jakarta.validation.Valid;

/**
 * Clase CtrlCategory
 * Controlador con los endpoints relacionados con la gestión
 * de categorías.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */

@RestController
@RequestMapping("/category")
public class CtrlCategory {

    @Autowired
	SvcCategory svc;

	/**
	 * Encuentra todas las categorías en la base de datos
	 * @return regresa un ResponseEntity con una lista de categorías
	 * @throws DBAccessException arroja una excepción DBAccessException en caso de que haya algún error
	 */
	@GetMapping
	public ResponseEntity<List<Category>> findAll() throws DBAccessException{
		return ResponseEntity.ok(svc.findAll());
	}
	
	/**
	 * Encuentra todas las categorías activas 
	 * @return regresa una ResponseEntity con una lista de categorías
	 */
	@GetMapping("/active")
	public ResponseEntity<List<Category>> findActive(){
		return ResponseEntity.ok(svc.findActive());
	}
	
	/**
	 * Crea una nueva categoría y llama al servicio correspondiente
	 * @param in dto para crear la nueva categoría
	 * @return regresa ResponseEntity con una ApiResponse
	 */
	@PostMapping
	public ResponseEntity<ApiResponse> create(@Valid @RequestBody DtoCategoryIn in) {
		return ResponseEntity.ok(svc.create(in));
	}
	
	/**
	 * Actualiza una categoría dado un dto y un id 
	 * @param in dto con los datos correspondiente
	 * @param id id de la categoría a actualizar
	 * @return ResponseEntity con una ApiResponse
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> update(@Valid @RequestBody DtoCategoryIn in, @PathVariable("id") Integer id){
		return ResponseEntity.ok(svc.update(in, id));
	}

	/**
	 * Activa una categoría dado un id 
	 * @param id de la categoría a activar
	 * @return regresa un ResponseEntity con una ApiResponse
	 */
	@PatchMapping("/{id}/enable")
	public ResponseEntity<ApiResponse> enable(@PathVariable Integer id) {
		return ResponseEntity.ok(svc.enable(id));
	}

	/**
	 * Desactiva una categoría dado un id
	 * @param id de la categoría a desactivar
	 * @return regresa un ResponseEntity con una ApiResponse
	 */
	@PatchMapping("/{id}/disable")
	public ResponseEntity<ApiResponse> disable(@PathVariable Integer id) {
		return ResponseEntity.ok(svc.disable(id));
	}
    
}
