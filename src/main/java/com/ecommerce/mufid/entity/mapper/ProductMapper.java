package com.ecommerce.mufid.entity.mapper;

import com.ecommerce.mufid.dto.ProductDTO;
import com.ecommerce.mufid.entity.Category;
import com.ecommerce.mufid.entity.Product;

public class ProductMapper {

    public ProductDTO toDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setProductDescription(product.getProductDescription());
        dto.setPrice(product.getPrice());
        dto.setCategoryId(product.getCategory().getCategoryId());
        return dto;
    }

    public Product toEntity(ProductDTO dto, Category category) {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(category);
        return product;
    }
}


