package com.ecommerce.mufid.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuotationDTO {

    private Long quotationId;
    private String nomor;
    private String quotationType;
    private int total;
    private int tax;
    private Long shippingId;
    private Integer additionalShipping;
    private int grandTotal;
    private double grandBerat;
    private int estimasiPengiriman;
    private int estimasiProduksi;
    private String notes;
    private String financeStatus;
    private String financeNote;
    private String logisticStatus;

}
