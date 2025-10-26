package com.product.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.service.SvcProductImage;
import com.product.common.dto.ApiResponse;

@RestController
@RequestMapping("/product-image")
public class CtrlProductImage {
    @Autowired
    SvcProductImage svc;

    @PostMapping
    public ResponseEntity<ApiResponse> createProductImage(@Valid @RequestBody DtoProductImageIn in){
   	    return ResponseEntity.ok(svc.uploadProductImage(in));
    }
}
