package com.product.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.in.DtoProductIn;
import com.product.api.dto.out.DtoProductListOut;
import com.product.api.dto.out.DtoProductOut;
import com.product.api.service.SvcProduct;
import com.product.common.dto.ApiResponse;
import com.product.exception.ApiException;
import com.product.exception.DBAccessException;
import com.product.api.dto.out.DtoProductOut;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
@Tag(name = "Product", description = "Operaciones relacionadas los productos")
public class CtrlProduct {

	@Autowired
	SvcProduct svc;

	/**
	 * Obtiene la lista de todos productos
	 * @return lista de productos
	 */
	@GetMapping
	@Operation(
		summary = "Encuentra los productos", 
		description = "Regresa una lista con los productos")
	public ResponseEntity<List<DtoProductListOut>> getProducts() {
		return svc.getProducts();
	}

	/**
	 * Obtiene un producto por su id
	 * @param id id del producto a obtener
	 * @return regresa el producto solicitado
	 */
	@GetMapping("/{id}")
	@Operation(
		summary = "Encuentra un producto", 
		description = "Obtiene el prouducto solicitado")
	public ResponseEntity<DtoProductOut> getProduct(@PathVariable Integer id) {
		return svc.getProduct(id);
	}

	/**
	 * Crea un nuevo producto
	 * @param in datos del producto a crear
	 * @param bindingResult resultado de la validación de los datos de entrada
	 * @return regresa una respuesta de APIResponse indicando el resultado de la operación
	 */
	@PostMapping
	@Operation(
		summary = "Crea un producto", 
		description = "Regresa un APIResponse con el resultado de la operación")
	public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody DtoProductIn in,
	BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
		}
		return svc.createProduct(in);
	}

	/**
	 * Actualiza un producto dado su id y el dto necesario para actualizarlo
	 * @param id id del producto a actualizar
	 * @param in dto con los datos necesarios para actualizar el producto
	 * @param bindingResult resultado de la validación de los datos de entrada
	 * @return regresa un APIResponse indicando el resultado de la operación
	 */
	@PutMapping("/{id}")
	@Operation(
		summary = "Actualiza un producto", 
		description = "Regresa un APIResponse con el resultado de la oepración")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable Integer id, @Valid @RequestBody DtoProductIn in,
	BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
		}
		return svc.updateProduct(id, in);
	}

	/**
	 * Activa un producto escribiendo su status a 1
	 * @param id id del producto a activar 
	 * @return regresa un APIResponse del resultado de la operación
	 */
	@PatchMapping("/{id}/enable")
	@Operation(
		summary = "Activa un producto", 
		description = "Regresa un APIResponse con el resultado de la operación")
	public ResponseEntity<ApiResponse> enableProduct(@PathVariable Integer id) {
		return svc.enableProduct(id);
	}

	/**
	 * Desactiva un producto escribiendo su status a 0
	 * @param id id del producto a desactivar 
	 * @return regresa un APIResponse del resultado de la operación
	 */
	@PatchMapping("/{id}/disable")
	@Operation(
		summary = "Desactiva un producto", 
		description = "Regresa un APIResponse con el resultado de la operación")
	public ResponseEntity<ApiResponse> disableProduct(@PathVariable Integer id) {
		return svc.disableProduct(id);
	}

	// Agregados

	/**
	 * Obtiene un producto activo por su GTIN.
	 *
	 * @param gtin GTIN del producto a buscar (path variable).
	 * @return ResponseEntity con el DtoProductOut en caso de éxito.
	 * @throws ApiException si el producto no se encuentra (404).
	 * @throws DBAccessException si ocurre un error en la capa de acceso a datos.
	 */
	@GetMapping("/gtin/{gtin}")
	@Operation(summary = "Obtener producto por GTIN")
	public ResponseEntity<DtoProductOut> getProductByGtin(@PathVariable("gtin") String gtin) {
		return svc.getProductByGtin(gtin);
	}

	/**
	 * Actualiza (reduce) el stock de un producto identificado por su GTIN.
	 * 
	 * @param gtin     GTIN del producto (path variable).
	 * @param quantity Cantidad a restar del stock (path variable). Debe ser >= 1.
	 * @return ResponseEntity con un ApiResponse que contiene el mensaje de
	 *         la operación.
	 * @throws ApiException si stock insuficiente o producto no encontrado.
	 */
	@PutMapping("/{gtin}/stock/{quantity}")
	@Operation(summary = "Actualizar stock", description = "Resta stock del inventario")
	public ResponseEntity<ApiResponse> updateProductStock(@PathVariable("gtin") String gtin,
			@PathVariable("quantity") Integer quantity) {
		return svc.updateProductStock(gtin, quantity);
	}
}
