package com.ecommerce.mufid.controller;

import com.ecommerce.mufid.dto.QuotationDTO;
import com.ecommerce.mufid.service.QuotationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {

    private final QuotationService quotationService;

    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuotationDTO>> getAllQuotations() {
        List<QuotationDTO> quotations = quotationService.findAll();
        return ResponseEntity.ok(quotations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuotationDTO> getQuotationById(@PathVariable Long id) {
        QuotationDTO quotation = quotationService.findById(id);
        return ResponseEntity.ok(quotation);
    }

    @PostMapping("/create")
    public ResponseEntity<QuotationDTO> createQuotation(@RequestBody QuotationDTO quotationDTO) {
        QuotationDTO createdQuotation = quotationService.create(quotationDTO);
        return ResponseEntity.ok(createdQuotation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuotationDTO> updateQuotation(@PathVariable Long id, @RequestBody QuotationDTO quotationDTO) {
        QuotationDTO updatedQuotation = quotationService.update(id, quotationDTO);
        return ResponseEntity.ok(updatedQuotation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuotation(@PathVariable Long id) {
        quotationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
