package com.bodegas.parcial.controller;


import com.bodegas.parcial.model.Inventory;
import com.bodegas.parcial.model.Product;
import com.bodegas.parcial.model.Storage;
import com.bodegas.parcial.service.InventoryService;
import com.bodegas.parcial.service.ProductService;
import com.bodegas.parcial.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    private final ProductService productService;
    private final StorageService storageService;

    @QueryMapping
    public List<Inventory> searchInventoryByStorage(@Argument long storage_id){
        Storage storage = storageService.searchStorageByID(storage_id);
        return storage.getInventories();
    }

    @MutationMapping
    public Inventory registerProduct(@Argument long storage_id,
                                     @Argument int quantity,
                                     @Argument String name,
                                     @Argument double price,
                                     @Argument String description,
                                     @Argument String category ) {
        Product product = productService.registerProduct(name,description,  price, category);
        Inventory inventory = new Inventory(quantity, product, storageService.searchStorageByID(storage_id));
        return inventoryService.createInventory(inventory);
    }
}
