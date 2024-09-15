package com.ecommerce.mufid.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Long customerId;
    private String code;
    private String name;
    private String alamatPengiriman;

}
