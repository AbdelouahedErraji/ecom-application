package org.sid.inventoryservice.web;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repo.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryRestController {
    private ProductRepository productRepository;

    public InventoryRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/productss")
    @PreAuthorize("hasAuthority('USER')")
    public List<Product> productList() {
        List<Product> products = productRepository.findAll();
        return products;
    }
 }
