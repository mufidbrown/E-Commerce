package com.ecommerce.mufid.repository;

import com.ecommerce.mufid.entity.Logistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticRepository extends JpaRepository<Logistic, Long> {
}
