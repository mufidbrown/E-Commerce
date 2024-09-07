package com.ecommerce.mufid.controller;

import com.ecommerce.mufid.dto.DetailProductDTO;
import com.ecommerce.mufid.service.DetailProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detail-products")
public class DetailProductController {

    private final DetailProductService detailProductService;

    @Autowired
    public DetailProductController(DetailProductService detailProductService) {
        this.detailProductService = detailProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailProductDTO> getDetailProductById(@PathVariable Long id) {
        DetailProductDTO detailProductDTO = detailProductService.getDetailProductById(id);
        return ResponseEntity.ok(detailProductDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailProductDTO>> getAllDetailProducts() {
        List<DetailProductDTO> detailProducts = detailProductService.getAllDetailProducts();
        return ResponseEntity.ok(detailProducts);
    }

    @PostMapping("/create")
    public ResponseEntity<DetailProductDTO> createDetailProduct(@RequestBody DetailProductDTO detailProductDTO) {
        DetailProductDTO createdDetailProduct = detailProductService.createDetailProduct(detailProductDTO);
        return new ResponseEntity<>(createdDetailProduct, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<DetailProductDTO> updateDetailProduct(@PathVariable Long id, @RequestBody DetailProductDTO detailProductDTO) {
        DetailProductDTO updatedDetailProduct = detailProductService.updateDetailProduct(id, detailProductDTO);
        return ResponseEntity.ok(updatedDetailProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetailProduct(@PathVariable Long id) {
        detailProductService.deleteDetailProduct(id);
        return ResponseEntity.noContent().build();
    }
}
