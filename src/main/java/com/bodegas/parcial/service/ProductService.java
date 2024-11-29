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

        var product = Product.builder()
        .name(name)
        .description(description)
        .price(price)
        .category(category)
        .build();
        return productRepository.save(product);
    }
}
