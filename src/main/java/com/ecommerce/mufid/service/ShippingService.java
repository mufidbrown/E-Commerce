package com.ecommerce.mufid.service;

import com.ecommerce.mufid.entity.Logistic;
import com.ecommerce.mufid.entity.Shipping;

import java.util.List;

public interface ShippingService {

    Shipping saveShipping(Shipping shipping);
    Shipping updateShipping(Shipping shipping);
    void deleteShipping(Long id);
    Shipping getShippingById(Long id);
    List<Shipping> getAllShippings();

}
