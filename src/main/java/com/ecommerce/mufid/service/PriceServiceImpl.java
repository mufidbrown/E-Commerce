package com.ecommerce.mufid.service;


import com.ecommerce.mufid.dto.PriceDTO;
import com.ecommerce.mufid.dto.ProductDTO;
import com.ecommerce.mufid.entity.Price;
import com.ecommerce.mufid.entity.Product;
import com.ecommerce.mufid.entity.mapper.PriceMapper;
import com.ecommerce.mufid.repository.PriceRepository;
import com.ecommerce.mufid.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {


    private final ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository,
                            ProductRepository productRepository,
                            PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.productRepository = productRepository;
        this.priceMapper = priceMapper;
    }

//    @Override
//    @Transactional
//    public PriceDTO createPrice(PriceDTO priceDTO) {
//        Price price = priceMapper.toEntity(priceDTO);
//        priceRepository.save(price);
//        return priceMapper.toDto(price);
//    }


    @Override
    @Transactional
    public PriceDTO createPrice(PriceDTO priceDTO) {
        // Pastikan Product ID ada di dalam PriceDTO
        Long productId = priceDTO.getProductId();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Mapping PriceDTO ke Price entity dan menetapkan Product
        Price price = priceMapper.toEntity(priceDTO, product); // Now passing two arguments

        // Simpan Price entity ke repository
        priceRepository.save(price);

        // Kembalikan PriceDTO setelah disimpan
        return priceMapper.toDto(price);
    }

/*    @Override
    @Transactional
    public PriceDTO createPrice(PriceDTO priceDTO) {
        // Pastikan Product ID ada di dalam PriceDTO
        Long productId = priceDTO.getProductId();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Mapping PriceDTO ke Price entity dan menetapkan Product
        Price price = priceMapper.toEntity(priceDTO);
        price.setProduct(product); // Set the Product relationship

        // Simpan Price entity ke repository
        priceRepository.save(price);

        // Kembalikan PriceDTO setelah disimpan
        return priceMapper.toDto(price);
    }*/

    @Override
    @Transactional
    public PriceDTO updatePrice(Long priceId, PriceDTO priceDTO) {
        Price price = priceRepository.findById(priceId).orElseThrow(() -> new RuntimeException("Price not found"));
        price.setAmount(priceDTO.getAmount());
        priceRepository.save(price);
        return priceMapper.toDto(price);
    }

    @Override
    public PriceDTO getPriceById(Long priceId) {
        Price price = priceRepository.findById(priceId)
                .orElseThrow(() -> new RuntimeException("Price not found"));
        return priceMapper.toDto(price);
    }

    @Override
    public List<PriceDTO> getAllPrices() {
        return priceRepository.findAll().stream().map(priceMapper::toDto).toList();
    }

    @Override
    @Transactional
    public void deletePrice(Long priceId) {
        priceRepository.deleteById(priceId);
    }
}

