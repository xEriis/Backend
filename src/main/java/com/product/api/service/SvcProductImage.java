package com.product.api.service;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.common.dto.ApiResponse;

public interface SvcProductImage {
    public ApiResponse uploadProductImage(DtoProductImageIn in);

}
