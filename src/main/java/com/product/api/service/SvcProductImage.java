package com.product.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.entity.ProductImage;
import com.product.common.dto.ApiResponse;

public interface SvcProductImage {
    public ResponseEntity<ApiResponse> uploadProductImage(DtoProductImageIn in);
    public ResponseEntity<ApiResponse> deleteProductImage(Integer id, Integer product_image_id);
    public ResponseEntity<List<ProductImage>> getProductImages(Integer id);
}
