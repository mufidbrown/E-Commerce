package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.PriceDTO;

import java.util.List;
import java.util.Optional;

public interface PriceService {
    PriceDTO createPrice(PriceDTO priceDTO);
    PriceDTO updatePrice(Long priceId, PriceDTO priceDTO);
    PriceDTO getPriceById(Long priceId);
    List<PriceDTO> getAllPrices();
    void deletePrice(Long priceId);


}
