package com.tecnoshop.updateProducts.repository;

import com.tecnoshop.updateProducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByIdAndDeletedAtIsNull(Long id);

    Optional<Product> findBySkuAndDeletedAtIsNull(String sku);

}
