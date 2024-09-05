package com.ecommerce.mufid.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

        private Long productId;
        private String productName;
        private String productDescription;
        private Double price;
        private Long categoryId;

        // Getters and Setters
}
