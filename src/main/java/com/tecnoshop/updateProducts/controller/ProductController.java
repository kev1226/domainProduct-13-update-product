package com.tecnoshop.updateProducts.controller;

import com.tecnoshop.updateProducts.dto.ProductDTO;
import com.tecnoshop.updateProducts.model.Product;
import com.tecnoshop.updateProducts.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

}
