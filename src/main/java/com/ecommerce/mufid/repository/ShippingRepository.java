package com.ecommerce.mufid.repository;

import com.ecommerce.mufid.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
