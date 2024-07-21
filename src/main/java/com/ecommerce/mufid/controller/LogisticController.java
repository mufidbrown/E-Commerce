package com.ecommerce.mufid.controller;

import com.ecommerce.mufid.entity.Logistic;
import com.ecommerce.mufid.service.LogisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logistics")
@RequiredArgsConstructor
public class LogisticController {

    @Autowired
    private final LogisticService logisticService;

    @PostMapping("/create")
    public ResponseEntity<Logistic> createLogistic(@RequestBody Logistic logistic) {
        Logistic createdLogistic = logisticService.saveLogistic(logistic);
        return ResponseEntity.ok(createdLogistic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Logistic> updateLogistic(@PathVariable Long id, @RequestBody Logistic logistic) {
        logistic.setId(id);
        Logistic updatedLogistic = logisticService.updateLogistic(logistic);
        return ResponseEntity.ok(updatedLogistic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogistic(@PathVariable Long id) {
        logisticService.deleteLogistic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Logistic> getLogisticById(@PathVariable Long id) {
        Logistic logistic = logisticService.getLogisticById(id);
        return ResponseEntity.ok(logistic);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Logistic>> getAllLogistics() {
        List<Logistic> logistics = logisticService.getAllLogistics();
        return ResponseEntity.ok(logistics);
    }
}
