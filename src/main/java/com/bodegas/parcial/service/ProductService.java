package com.bodegas.parcial.service;

import com.bodegas.parcial.model.Product;
import com.bodegas.parcial.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

@Autowired
    private ProductRepository productRepository;

    private final StorageService storageService;

    public Product registerProduct(String name, String description, double price, String category) {

        Product product = new Product(name, description, price, category);
        return productRepository.save(product);
    }
}

