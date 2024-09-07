package com.ecommerce.mufid.entity.mapper;

import com.ecommerce.mufid.dto.ProductDTO;
import com.ecommerce.mufid.entity.Category;
import com.ecommerce.mufid.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class ProductMapper {

    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    private DetailProductMapper detailProductMapper;

    public ProductDTO toDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setProductDescription(product.getProductDescription());
        dto.setPrice(product.getPrice());
        dto.setCategoryId(product.getCategory().getCategoryId());
        return dto;

/*
        tambahan 07/09/2024
*/
//        dto.setPrices(product.getPrices().stream()
//                .map(priceMapper::toDto)
//                .collect(Collectors.toSet()));
//        dto.setDetailProduct(detailProductMapper.toDto(product.getDetailProduct()));
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


