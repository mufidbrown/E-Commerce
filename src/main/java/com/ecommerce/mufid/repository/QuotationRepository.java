package com.ecommerce.mufid.repository;

import com.ecommerce.mufid.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}
