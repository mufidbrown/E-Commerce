package com.ecommerce.mufid.entity.mapper;

import com.ecommerce.mufid.dto.DetailProductDTO;
import com.ecommerce.mufid.entity.DetailProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailProductMapper {

    @Autowired
    private PriceMapper priceMapper;


    public DetailProductDTO toDto(DetailProduct detailProduct) {
        DetailProductDTO dto = new DetailProductDTO();
        dto.setId(detailProduct.getId());
        dto.setDescription(detailProduct.getDescription());
        if (detailProduct.getPrice() != null) {
            dto.setPrice(priceMapper.toDto(detailProduct.getPrice()));
        }
        return dto;
    }

    public DetailProduct toEntity(DetailProductDTO dto) {
        DetailProduct detailProduct = new DetailProduct();
        detailProduct.setId(dto.getId());
        detailProduct.setDescription(dto.getDescription());
        return detailProduct;
    }
}
