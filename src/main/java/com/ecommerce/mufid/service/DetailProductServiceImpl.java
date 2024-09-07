package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.DetailProductDTO;
import com.ecommerce.mufid.dto.PriceDTO;
import com.ecommerce.mufid.dto.ProductDTO;
import com.ecommerce.mufid.entity.DetailProduct;
import com.ecommerce.mufid.entity.Price;
import com.ecommerce.mufid.entity.Product;
import com.ecommerce.mufid.entity.mapper.DetailProductMapper;
import com.ecommerce.mufid.repository.DetailProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailProductServiceImpl implements DetailProductService {

    private final DetailProductRepository detailProductRepository;
    private final PriceService priceService;
    private final DetailProductMapper detailProductMapper;

    @Autowired
    public DetailProductServiceImpl(DetailProductRepository detailProductRepository,
                                    PriceService priceService,
                                    DetailProductMapper detailProductMapper) {
        this.detailProductRepository = detailProductRepository;
        this.priceService = priceService;
        this.detailProductMapper = detailProductMapper;
    }

    @Override
    @Transactional
    public DetailProductDTO createDetailProduct(DetailProductDTO detailProductDTO) {
        PriceDTO priceDTO = priceService.createPrice(detailProductDTO.getPrice()); // Create or get existing price
        DetailProduct detailProduct = detailProductMapper.toEntity(detailProductDTO);
        detailProduct.setPrice(priceDTO);
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
