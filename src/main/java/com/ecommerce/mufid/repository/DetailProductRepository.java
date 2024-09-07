package com.ecommerce.mufid.repository;

import com.ecommerce.mufid.entity.DetailProduct;
import com.ecommerce.mufid.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailProductRepository extends JpaRepository<DetailProduct, Long> {
}
