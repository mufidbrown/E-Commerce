package com.ecommerce.mufid.entity.mapper;

import com.ecommerce.mufid.dto.PriceDTO;
import com.ecommerce.mufid.dto.ProductDTO;
import com.ecommerce.mufid.entity.Category;
import com.ecommerce.mufid.entity.Price;
import com.ecommerce.mufid.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {


    public PriceDTO toDto(Price price) {
        PriceDTO dto = new PriceDTO();
        dto.setId(price.getId());
        dto.setAmount(price.getAmount());
        dto.setProductId(price.getProduct().getProductId());
        return dto;
    }

    public Price toEntity(PriceDTO dto, Product product) {
        Price price = new Price();
        price.setId(dto.getId());
        price.setAmount(dto.getAmount());
        price.setProduct(product);
        return price;
    }


}
