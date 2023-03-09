package com.csidigital.management.service;

import com.csidigital.shared.dto.request.AddressRequest;
import com.csidigital.dao.entity.Address;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address create(Address address);
     List<Address> get();
     Optional<Address> getById(Long id);

     ResponseEntity<Address> update(AddressRequest address , Long id );

     void delete(Long id);
}
