package com.tecnoshop.updateProducts.service;

import com.tecnoshop.updateProducts.dto.ProductDTO;
import com.tecnoshop.updateProducts.model.Product;
import com.tecnoshop.updateProducts.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product update(Long id, ProductDTO dto) {
        Product existing = repo.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        // Validar si el nuevo SKU ya está usado por otro producto
        repo.findBySkuAndDeletedAtIsNull(dto.getSku()).ifPresent(p -> {
            if (!p.getId().equals(id)) {
                throw new IllegalArgumentException("SKU ya registrado en otro producto.");
            }
        });

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setPrice(dto.getPrice());
        existing.setStock(dto.getStock());
        existing.setSku(dto.getSku());
        existing.setIsPublished(dto.getIsPublished());

        return repo.save(existing);
    }
}
