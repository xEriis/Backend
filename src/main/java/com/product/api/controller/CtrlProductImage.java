package com.product.api.controller;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.dto.out.DtoProductOut;
import com.product.api.entity.ProductImage;
import com.product.api.service.SvcProductImage;
import com.product.common.dto.ApiResponse;
import com.product.exception.ApiException;

@RestController
@RequestMapping("/product/{id}/image")
public class CtrlProductImage {

    @Autowired
    SvcProductImage svc;

    @PostMapping
    public ResponseEntity<ApiResponse> createProductImage(@Valid @RequestBody DtoProductImageIn in,
    BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
		}
   	    return svc.uploadProductImage(in);
    }

    @DeleteMapping("/{product_image_id}")
    public ResponseEntity<ApiResponse> deleteProductImage(@PathVariable Integer id, @PathVariable Integer product_image_id) {
   	    return svc.deleteProductImage(id, product_image_id);
    }

    @GetMapping
	  public ResponseEntity<List<ProductImage>> getProductImages(@PathVariable Integer id) {
  		return svc.getProductImages(id);
	  }
}
