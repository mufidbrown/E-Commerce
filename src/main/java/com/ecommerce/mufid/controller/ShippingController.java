package com.ecommerce.mufid.controller;

import com.ecommerce.mufid.entity.Shipping;
import com.ecommerce.mufid.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shippings")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/create")
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {
        try {
            Shipping savedShipping = shippingService.saveShipping(shipping);
            return new ResponseEntity<>(savedShipping, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipping> updateShipping(@PathVariable Long id, @RequestBody Shipping shipping) {
        shipping.setId(id);
        try {
            Shipping updatedShipping = shippingService.updateShipping(shipping);
            return new ResponseEntity<>(updatedShipping, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipping(@PathVariable Long id) {
        try {
            shippingService.deleteShipping(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipping> getShippingById(@PathVariable Long id) {
        try {
            Shipping shipping = shippingService.getShippingById(id);
            return new ResponseEntity<>(shipping, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Shipping>> getAllShippings() {
        List<Shipping> shippings = shippingService.getAllShippings();
        return new ResponseEntity<>(shippings, HttpStatus.OK);
    }
}

