package com.study.marketbackend.repository;

import com.study.marketbackend.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
