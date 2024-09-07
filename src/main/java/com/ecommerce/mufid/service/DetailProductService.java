package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.DetailProductDTO;

import java.util.List;
import java.util.Optional;

public interface DetailProductService {

    DetailProductDTO createDetailProduct(DetailProductDTO detailProductDTO);
    DetailProductDTO updateDetailProduct(Long detailProductId, DetailProductDTO detailProductDTO);
    DetailProductDTO getDetailProductById(Long detailProductId);
    List<DetailProductDTO> getAllDetailProducts();
    void deleteDetailProduct(Long detailProductId);

}
