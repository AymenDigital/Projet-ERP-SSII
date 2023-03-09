package com.csidigital.management.service.implementation;

import com.csidigital.shared.dto.request.AddressRequest;
import com.csidigital.dao.entity.Address;
import com.csidigital.shared.exceptions.ResourceNotFoundException;
import com.csidigital.dao.repository.AddressRepository;
import com.csidigital.management.service.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
 public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository ;
    @Override
    public Address create(Address address) {
        return addressRepository.save(address); }

    @Override
    public List<Address> get() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
        public ResponseEntity<Address> update(AddressRequest addressDetails , Long id) {
        Address addr = addressRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("address with id " +id+ " not found"));
                addr.setAddressTitle(addressDetails.getAddressTitle());
                addressRepository.save(addr);
    return ResponseEntity.ok(addr);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);

    }
}
