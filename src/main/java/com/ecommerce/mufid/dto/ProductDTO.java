package com.ecommerce.mufid.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductDTO {

        private Long productId;
        private String productName;
        private String productDescription;
        private Double price;
        private Long categoryId;
//        private Set<PriceDTO> prices;



        // Getters and Setters
}
