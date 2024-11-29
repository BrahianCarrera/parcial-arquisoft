package com.bodegas.parcial.service;

import com.bodegas.parcial.model.Storage;
import com.bodegas.parcial.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public List<Storage> searchStorages(){ return storageRepository.findAll(); }

    public Storage searchStorageByID( long storage_id ) {
        return storageRepository.findById(storage_id).orElseThrow();
    }

    public Storage createStorage(Storage storage){ return storageRepository.save(storage); }
}
