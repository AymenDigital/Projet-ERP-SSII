package com.csidigital.management.service;

import com.csidigital.shared.dto.request.AddressRequest;
import com.csidigital.dao.entity.Address;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.AddressResponse;
import com.csidigital.shared.dto.response.RequirementResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    AddressResponse createAddress(AddressRequest request);
    List<AddressResponse> getAllAddresses();
    AddressResponse getAddressById(Long id);

    AddressResponse updateAddress(AddressRequest request, Long id);

    void deleteAddress(Long id);
}
