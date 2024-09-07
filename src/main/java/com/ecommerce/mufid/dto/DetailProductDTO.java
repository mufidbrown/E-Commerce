package com.ecommerce.mufid.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailProductDTO {

    private Long id;
    private String Description;
    private PriceDTO price;

}
