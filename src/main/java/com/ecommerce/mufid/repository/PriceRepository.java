package com.ecommerce.mufid.repository;

import com.ecommerce.mufid.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
