package com.shopping.delivery.Service;

import com.shopping.delivery.DTO.ProductDetailsDto;

public interface ProductDetailsService  {

    void saveTheProduct(ProductDetailsDto productDetailsDto);

    ProductDetailsDto getProductDetails(Long productId);
}
