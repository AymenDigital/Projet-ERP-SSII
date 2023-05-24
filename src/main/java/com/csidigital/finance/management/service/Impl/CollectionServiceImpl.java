package com.csidigital.finance.management.service.Impl;


import com.csidigital.finance.dao.entity.AdditionalFee;
import com.csidigital.finance.dao.entity.Bill;
import com.csidigital.finance.dao.entity.BillClient;
import com.csidigital.finance.dao.entity.Collection;
import com.csidigital.finance.dao.repository.CollectionRepository;
import com.csidigital.finance.management.service.CollectionService;
import com.csidigital.finance.shared.dto.Request.AdditionalFeeDtoRequest;
import com.csidigital.finance.shared.dto.Request.BillDtoRequest;
import com.csidigital.finance.shared.dto.Request.CollectionDtoRequest;
import com.csidigital.finance.shared.dto.Response.AdditionalFeeDtoResponse;
import com.csidigital.finance.shared.dto.Response.CollectionDtoResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CollectionDtoResponse> getAllCollections() {
        List<Collection> collections = collectionRepository.findAll();
        List<CollectionDtoResponse> collectionList = new ArrayList<>();

        for (Collection collection : collections) {
            CollectionDtoResponse collectionResponse = modelMapper.map(collection, CollectionDtoResponse.class);
            collectionList.add(collectionResponse);
        }

        return collectionList;
    }

    @Override
    public CollectionDtoResponse getByIdCollection(Long id) {
        Collection collection = collectionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Collection with id " +id+ " not found"));
        CollectionDtoResponse collectionDtoResponse = modelMapper.map(collection, CollectionDtoResponse.class);
        return collectionDtoResponse;    }

    @Override
    public CollectionDtoResponse CreateCollection(CollectionDtoRequest collectionDtoRequest) {
        Collection collection = modelMapper.map(collectionDtoRequest, Collection.class);

        Collection CollectionSaved = collectionRepository.save(collection);
        return modelMapper.map(CollectionSaved, CollectionDtoResponse.class);
    }


    @Override
    public CollectionDtoResponse updateCollection(@Valid CollectionDtoRequest request, Long id) {
        Collection existingCollection = collectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collection with id: " + id + " not found"));

        // Conserver la référence du billClient existant
        BillClient billClient = existingCollection.getBillClient();

        // Effectuer la mise à jour des attributs de la collection
        existingCollection.setCategory(request.getCategory());
        existingCollection.setInvoiceNumber(request.getInvoiceNumber());
        existingCollection.setAmount(request.getAmount());
        existingCollection.setDate(request.getDate());
        existingCollection.setDescription(request.getDescription());
        existingCollection.setTreasuryType(request.getTreasuryType());

        // Rétablir la référence du billClient existant
        existingCollection.setBillClient(billClient);

        Collection savedCollection = collectionRepository.save(existingCollection);
        return modelMapper.map(savedCollection, CollectionDtoResponse.class);
    }




    @Override
    public void deleteCollectionById(Long id) {
        Collection collection = collectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collection with id " + id + " not found"));

        collectionRepository.deleteById(id);
    }

}
