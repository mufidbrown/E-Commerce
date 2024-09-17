package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.QuotationDTO;
import com.ecommerce.mufid.entity.Customer;
import com.ecommerce.mufid.entity.Quotation;
import com.ecommerce.mufid.entity.Shipping;
import com.ecommerce.mufid.entity.mapper.QuotationMapper;
import com.ecommerce.mufid.repository.CustomerRepository;
import com.ecommerce.mufid.repository.QuotationRepository;
import com.ecommerce.mufid.repository.ShippingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private final QuotationRepository quotationRepository;
    private final QuotationMapper quotationMapper;

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public QuotationServiceImpl(QuotationRepository quotationRepository, QuotationMapper quotationMapper) {
        this.quotationRepository = quotationRepository;
        this.quotationMapper = quotationMapper;
    }

    @Override
    public List<QuotationDTO> findAll() {
        return quotationRepository.findAll()
                .stream()
                .map(quotationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public QuotationDTO findById(Long id) {
        return quotationRepository.findById(id)
                .map(quotationMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Quotation not found"));
    }

//    @Override
//    public QuotationDTO create(QuotationDTO quotationDTO) {
//        Quotation quotation = quotationMapper.toEntity(quotationDTO, Shipping, Customer);
//        Quotation savedQuotation = quotationRepository.save(quotation);
//        return quotationMapper.toDto(savedQuotation);
//    }

    @Override
    @Transactional
    public QuotationDTO create(QuotationDTO quotationDTO) {
        // Fetch Customer and Shipping entities if IDs are provided
        Customer customer = null;
        Shipping shipping = null;

        if (quotationDTO.getCustomerId() != null) {
            customer = customerRepository.findById(quotationDTO.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
        }

        if (quotationDTO.getShippingId() != null) {
            shipping = shippingRepository.findById(quotationDTO.getShippingId())
                    .orElseThrow(() -> new RuntimeException("Shipping not found"));
        }

        // Map DTO to entity, including Shipping and Customer
        Quotation quotation = quotationMapper.toEntity(quotationDTO, shipping, customer);

        // Save the new Quotation
        Quotation savedQuotation = quotationRepository.save(quotation);

        // Convert saved entity to DTO and return
        return quotationMapper.toDto(savedQuotation);
    }

//    @Override
//    public QuotationDTO update(Long id, QuotationDTO quotationDTO) {
//        return null;
//    }


//    @Override
//    public QuotationDTO update(Long id, QuotationDTO quotationDTO) {
//        Quotation existingQuotation = quotationRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Quotation not found"));
//        Quotation updatedQuotation = quotationMapper.toEntity(quotationDTO, Shipping, Customer);
//        updatedQuotation.setQuotationId(existingQuotation.getQuotationId()); // Keep the same ID
//        Quotation savedQuotation = quotationRepository.save(updatedQuotation);
//        return quotationMapper.toDto(savedQuotation);
//    }



    @Override
    public void delete(Long id) {
        Quotation quotation = quotationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quotation not found"));
        quotationRepository.delete(quotation);
    }
}
