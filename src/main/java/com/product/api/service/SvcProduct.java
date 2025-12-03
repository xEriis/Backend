package com.product.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.dto.in.DtoProductIn;
import com.product.api.dto.out.DtoProductListOut;
import com.product.api.dto.out.DtoProductOut;
import com.product.common.dto.ApiResponse;
import com.product.exception.ApiException;

/**
 * Interfaz para el servicio de productos
 */
public interface SvcProduct {

	/**
	 * Getter para obtener la lista de productos
	 * 
	 * @return ResponseEntity con la lista de productos
	 */
	public ResponseEntity<List<DtoProductListOut>> getProducts();

	/**
	 * Getter para obtener un producto por su id
	 * 
	 * @param id identificador del producto
	 * @return ResponseEntity con el producto solicitado
	 */
	public ResponseEntity<DtoProductOut> getProduct(Integer id);

	/**
	 * Método para crear un nuevo producto
	 * 
	 * @param in un objeto DtoProductIn
	 * @return ResponseEntity
	 */
	public ResponseEntity<ApiResponse> createProduct(DtoProductIn in);

	/**
	 * Método para actualizar un producto existente
	 * 
	 * @param id identificador del producto a actualizar
	 * @param in objeto DtoProductIn con la información
	 * @return ResponseEntity con un ApiResponse
	 */
	public ResponseEntity<ApiResponse> updateProduct(Integer id, DtoProductIn in);

	/**
	 * Metodo para habilitar un producto
	 * 
	 * @param id identificador del producto a habilitar
	 * @return ResponseEntity con un ApiResponse
	 */
	public ResponseEntity<ApiResponse> enableProduct(Integer id);

	/**
	 * Metodo para deshabilitar un producto
	 * 
	 * @param id identificador del producto a deshabilitar
	 * @return ResponseEntity con un ApiResponse
	 */
	public ResponseEntity<ApiResponse> disableProduct(Integer id);

	// Agregados

	/**
	 * Método para obtener un producto por GTIN.
	 *
	 * @param gtin GTIN del producto.
	 * @return ResponseEntity con DtoProductOut y código HTTP apropiado.
	 * @throws ApiException si no se encuentra el producto.
	 */
	public ResponseEntity<DtoProductOut> getProductByGtin(String gtin);

	/**
	 * Método para actualizar (restar) la cantidad indicada del stock del producto identificado por GTIN.
	 *
	 * @param gtin     GTIN del producto.
	 * @param quantity Cantidad a restar del stock.
	 * @return ResponseEntity con ApiResponse (mensaje) y código HTTP
	 *         apropiado.
	 * @throws ApiException si producto no encontrado o stock insuficiente.
	 */
	public ResponseEntity<ApiResponse> updateProductStock(String gtin, Integer quantity);

}