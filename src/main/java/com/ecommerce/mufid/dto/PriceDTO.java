package com.ecommerce.mufid.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class PriceDTO {

        private Long id;
        private BigDecimal amount;
        private Long productId; // Untuk relasi


}
