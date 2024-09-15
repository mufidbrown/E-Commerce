package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.QuotationDTO;
import com.ecommerce.mufid.entity.Quotation;
import com.ecommerce.mufid.entity.mapper.QuotationMapper;
import com.ecommerce.mufid.repository.QuotationRepository;
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

    @Override
    public QuotationDTO create(QuotationDTO quotationDTO) {
        Quotation quotation = quotationMapper.toEntity(quotationDTO);
        Quotation savedQuotation = quotationRepository.save(quotation);
        return quotationMapper.toDto(savedQuotation);
    }

    @Override
    public QuotationDTO update(Long id, QuotationDTO quotationDTO) {
        Quotation existingQuotation = quotationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quotation not found"));
        Quotation updatedQuotation = quotationMapper.toEntity(quotationDTO);
        updatedQuotation.setQuotationId(existingQuotation.getQuotationId()); // Keep the same ID
        Quotation savedQuotation = quotationRepository.save(updatedQuotation);
        return quotationMapper.toDto(savedQuotation);
    }

    @Override
    public void delete(Long id) {
        Quotation quotation = quotationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quotation not found"));
        quotationRepository.delete(quotation);
    }
}
