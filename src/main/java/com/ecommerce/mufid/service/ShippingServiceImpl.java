package com.ecommerce.mufid.service;

import com.ecommerce.mufid.entity.Logistic;
import com.ecommerce.mufid.entity.Shipping;
import com.ecommerce.mufid.repository.LogisticRepository;
import com.ecommerce.mufid.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private LogisticRepository logisticRepository;

    @Override
    public Shipping saveShipping(Shipping shipping) {
        // Ensure logistic exists before saving shipping
        Optional<Logistic> logistic = logisticRepository.findById(shipping.getLogistic().getId());
        if (logistic.isPresent()) {
            return shippingRepository.save(shipping);
        } else {
            throw new RuntimeException("Logistic not found");
        }
    }

    @Override
    public Shipping updateShipping(Shipping shipping) {
        if (shippingRepository.existsById(shipping.getId())) {
            return shippingRepository.save(shipping);
        } else {
            throw new RuntimeException("Shipping not found");
        }
    }

    @Override
    public void deleteShipping(Long id) {
        if (shippingRepository.existsById(id)) {
            shippingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Shipping not found");
        }
    }

    @Override
    public Shipping getShippingById(Long id) {
        return shippingRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipping not found"));
    }

    @Override
    public List<Shipping> getAllShippings() {
        return shippingRepository.findAll();
    }
}
