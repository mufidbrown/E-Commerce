package com.ecommerce.mufid.controller;

import com.ecommerce.mufid.dto.QuotationDTO;
import com.ecommerce.mufid.service.QuotationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
//
//    @PostMapping("/create")
//    public ResponseEntity<QuotationDTO> createQuotation(@RequestBody QuotationDTO quotationDTO) {
//        // Validate the quotation type
//        if (!isValidQuotationType(quotationDTO.getQuotationType())) {
//            throw new IllegalArgumentException("Invalid quotation type");
//        }
//
//        try {
//            // Create the quotation
//            QuotationDTO createdQuotation = quotationService.create(quotationDTO);
//            // Return the response
//            return ResponseEntity.ok(createdQuotation);
//        } catch (Exception e) {
//            // Handle unexpected exceptions
//            throw new RuntimeException("Failed to create quotation: " + e.getMessage(), e);
//        }

//    }
//
//    private boolean isValidQuotationType(String quotationType) {
//        // Define valid types
//        return Arrays.asList("STANDARD", "EXPRESS").contains(quotationType);



    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<QuotationDTO> updateQuotation(@PathVariable Long id, @RequestBody QuotationDTO quotationDTO) {
//        QuotationDTO updatedQuotation = quotationService.update(id, quotationDTO);
//        return ResponseEntity.ok(updatedQuotation);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuotation(@PathVariable Long id) {
        quotationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
