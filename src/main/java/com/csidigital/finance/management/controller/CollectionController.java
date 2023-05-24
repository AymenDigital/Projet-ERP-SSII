package com.csidigital.finance.management.controller;

import com.csidigital.finance.dao.entity.Collection;
import com.csidigital.finance.management.service.CollectionService;
import com.csidigital.finance.management.service.TreasuryService;
import com.csidigital.finance.shared.dto.Request.CollectionDtoRequest;
import com.csidigital.finance.shared.dto.Request.TreasuryDtoRequest;
import com.csidigital.finance.shared.dto.Response.CollectionDtoResponse;
import com.csidigital.finance.shared.dto.Response.TreasuryDtoResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fm/collections")
@CrossOrigin("*")
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;

}
    @GetMapping()
    public List<CollectionDtoResponse> getAllCollection() {
        return collectionService.getAllCollections();
    }

    @GetMapping("/{id}")
    public CollectionDtoResponse getCollectionById(@PathVariable Long id){
        return collectionService.getByIdCollection(id);
    }

    @PostMapping()
    public CollectionDtoResponse createCollection(@RequestBody CollectionDtoRequest collectionDtoRequest){
        return collectionService.CreateCollection(collectionDtoRequest);
    }

    @PutMapping("/{id}")
    public CollectionDtoResponse updateCollection(@Valid @RequestBody  CollectionDtoRequest collectionDtoRequest, @PathVariable Long id){
        return collectionService.updateCollection(collectionDtoRequest, id);
    }


    @DeleteMapping("/{id}")
    public void deleteCollection(@PathVariable Long id){
        collectionService.deleteCollectionById(id);
    }
}
