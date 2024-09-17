package com.ecommerce.mufid.entity.mapper;

import com.ecommerce.mufid.dto.QuotationDTO;
import com.ecommerce.mufid.entity.*;
import org.springframework.stereotype.Component;

@Component
public class QuotationMapper {

    public QuotationDTO toDto(Quotation quotation) {
        QuotationDTO dto = new QuotationDTO();
        dto.setQuotationId(quotation.getQuotationId());
        dto.setNomor(quotation.getNomor());
        dto.setQuotationType(quotation.getQuotationType() != null ? quotation.getQuotationType().name() : null); // Enum to String
        dto.setTotal(quotation.getTotal());
        dto.setTax(quotation.getTax());
        dto.setAdditionalShipping(quotation.getAdditionalShipping());
        dto.setGrandTotal(quotation.getGrandTotal());
        dto.setGrandBerat(quotation.getGrandBerat());
        dto.setEstimasiPengiriman(quotation.getEstimasiPengiriman());
        dto.setEstimasiProduksi(quotation.getEstimasiProduksi());
        dto.setNotes(quotation.getNotes());
        dto.setFinanceStatus(quotation.getFinanceStatus() != null ? quotation.getFinanceStatus().name() : null); // Enum to String
        dto.setFinanceNote(quotation.getFinanceNote());
        dto.setLogisticStatus(quotation.getFinanceStatus() != null ? quotation.getLogisticStatus().name() : null); // Enum to String
        dto.setShippingId(quotation.getShipping().getId());
        dto.setCustomerId(quotation.getCustomer().getCustomerId());
        return dto;
    }
    public Quotation toEntity(QuotationDTO dto, Shipping shipping, Customer customer) {
        Quotation quotation = new Quotation();
        quotation.setNomor(dto.getNomor());
        quotation.setQuotationType(dto.getQuotationType() != null ? QuotationType.valueOf(dto.getQuotationType()) : null); // String to Enum
        quotation.setTotal(dto.getTotal());
        quotation.setTax(dto.getTax());
        quotation.setGrandTotal(dto.getGrandTotal());
        quotation.setGrandBerat(dto.getGrandBerat());
        quotation.setEstimasiPengiriman(dto.getEstimasiPengiriman());
        quotation.setEstimasiProduksi(dto.getEstimasiProduksi());
        quotation.setNotes(dto.getNotes());
        quotation.setFinanceStatus(dto.getFinanceStatus() != null ? FinanceStatus.valueOf(dto.getFinanceStatus()) : null); // String to Enum
        quotation.setFinanceNote(dto.getFinanceNote());
        quotation.setLogisticStatus(dto.getFinanceStatus() != null ? LogisticStatus.valueOf(dto.getLogisticStatus()) : null); // String to Enum
        quotation.setShipping(shipping);
        quotation.setCustomer(customer);
        return quotation;
    }
}
