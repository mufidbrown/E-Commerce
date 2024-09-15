package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.QuotationDTO;

import java.util.List;

public interface QuotationService {

        List<QuotationDTO> findAll();
        QuotationDTO findById(Long id);
        QuotationDTO create(QuotationDTO quotationDTO);
        QuotationDTO update(Long id, QuotationDTO quotationDTO);
        void delete(Long id);

}
