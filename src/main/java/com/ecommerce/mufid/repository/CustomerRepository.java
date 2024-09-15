package com.ecommerce.mufid.repository;

import com.ecommerce.mufid.entity.Category;
import com.ecommerce.mufid.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
