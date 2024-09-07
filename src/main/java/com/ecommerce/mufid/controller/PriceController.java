package com.ecommerce.mufid.controller;

import com.ecommerce.mufid.dto.PriceDTO;
import com.ecommerce.mufid.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceDTO> getPriceById(@PathVariable Long id) {
        PriceDTO priceDTO = priceService.getPriceById(id);
        return ResponseEntity.ok(priceDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PriceDTO>> getAllPrices() {
        List<PriceDTO> prices = priceService.getAllPrices();
        return ResponseEntity.ok(prices);
    }

    @PostMapping("/create")
    public ResponseEntity<PriceDTO> createPrice(@RequestBody PriceDTO priceDTO) {
        PriceDTO createdPrice = priceService.createPrice(priceDTO);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceDTO> updatePrice(@PathVariable Long id, @RequestBody PriceDTO priceDTO) {
        PriceDTO updatedPrice = priceService.updatePrice(id, priceDTO);
        return ResponseEntity.ok(updatedPrice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        priceService.deletePrice(id);
        return ResponseEntity.noContent().build();
    }
}
