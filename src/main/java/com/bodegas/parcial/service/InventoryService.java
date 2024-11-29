package com.bodegas.parcial.service;

import com.bodegas.parcial.model.Inventory;
import com.bodegas.parcial.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired

    private InventoryRepository inventoryRepository;

    public List<Inventory> searchInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
