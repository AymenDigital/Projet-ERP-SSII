package com.csidigital.finance.management.service;

import com.csidigital.finance.shared.dto.Request.AdditionalFeeDtoRequest;
import com.csidigital.finance.shared.dto.Request.BillDtoRequest;
import com.csidigital.finance.shared.dto.Request.CollectionDtoRequest;
import com.csidigital.finance.shared.dto.Response.AdditionalFeeDtoResponse;
import com.csidigital.finance.shared.dto.Response.BillDtoResponse;
import com.csidigital.finance.shared.dto.Response.CollectionDtoResponse;

import java.util.List;

public interface CollectionService {
    //Get All Collection

    List<CollectionDtoResponse> getAllCollections();

    //Get Collection by id

    CollectionDtoResponse getByIdCollection(Long id);

    //Add new Collection

    CollectionDtoResponse CreateCollection(CollectionDtoRequest CollectionDtoRequest);

    //Update Collection by id
    CollectionDtoResponse updateCollection(CollectionDtoRequest request, Long id);
    //delete Collection by id
    void deleteCollectionById(Long id);


}
