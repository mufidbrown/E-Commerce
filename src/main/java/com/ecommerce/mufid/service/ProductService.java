package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProducts();
    ProductDTO createProduct(ProductDTO productDTO);
    void deleteProduct(Long id);
}
