package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.DetailProductDTO;
import com.ecommerce.mufid.dto.PriceDTO;
import com.ecommerce.mufid.dto.ProductDTO;
import com.ecommerce.mufid.entity.DetailProduct;
import com.ecommerce.mufid.entity.Price;
import com.ecommerce.mufid.entity.Product;
import com.ecommerce.mufid.entity.mapper.DetailProductMapper;
import com.ecommerce.mufid.repository.DetailProductRepository;
import com.ecommerce.mufid.repository.PriceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailProductServiceImpl implements DetailProductService {

    private final DetailProductRepository detailProductRepository;
    private final PriceRepository priceRepository;
    private final DetailProductMapper detailProductMapper;

    @Autowired
    public DetailProductServiceImpl(DetailProductRepository detailProductRepository,
                                    PriceRepository priceRepository,
                                    DetailProductMapper detailProductMapper) {
        this.detailProductRepository = detailProductRepository;
        this.priceRepository = priceRepository;
        this.detailProductMapper = detailProductMapper;
    }

    @Override
    @Transactional
    public DetailProductDTO createDetailProduct(DetailProductDTO detailProductDTO) {
        Price price = priceRepository.findById(detailProductDTO.getPrice().getId())
                .orElseThrow(() -> new RuntimeException("Price not found"));
        DetailProduct detailProduct = detailProductMapper.toEntity(detailProductDTO, price);
        DetailProduct savedDetailProduct = detailProductRepository.save(detailProduct);
        return detailProductMapper.toDto(savedDetailProduct);
    }


//    @Override
//    @Transactional
//    public DetailProductDTO createDetailProduct(DetailProductDTO detailProductDTO) {
//        DetailProduct detailProduct = detailProductMapper.toEntity(detailProductDTO);
//        detailProductRepository.save(detailProduct);
//        return detailProductMapper.toDto(detailProduct);
//    }

    @Override
    @Transactional
    public DetailProductDTO updateDetailProduct(Long detailProductId, DetailProductDTO detailProductDTO) {
        DetailProduct detailProduct = detailProductRepository.findById(detailProductId).orElseThrow(() -> new RuntimeException("DetailProduct not found"));
//        detailProduct.setDetail(detailProductDTO.getDetail());
        detailProductRepository.save(detailProduct);
        return detailProductMapper.toDto(detailProduct);
    }


    @Override
    public DetailProductDTO getDetailProductById(Long detailProductId) {
        DetailProduct detailProduct = detailProductRepository.findById(detailProductId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return detailProductMapper.toDto(detailProduct);
    }

    @Override
    public List<DetailProductDTO> getAllDetailProducts() {
        return detailProductRepository.findAll().stream().map(detailProductMapper::toDto).toList();
    }

    @Override
    @Transactional
    public void deleteDetailProduct(Long detailProductId) {
        detailProductRepository.deleteById(detailProductId);
    }
}
