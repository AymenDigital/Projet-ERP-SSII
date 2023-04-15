package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Partner;
import com.csidigital.dao.entity.ContactPartner;
import com.csidigital.dao.repository.PartnerContactRepository;
import com.csidigital.dao.repository.PartnerRepository;
import com.csidigital.management.service.ContactPService;
import com.csidigital.shared.dto.request.ContactPRequest;
import com.csidigital.shared.dto.response.PartnerContactResponse;
import com.csidigital.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ContactPServiceImpl implements ContactPService {
    @Autowired
    private PartnerContactRepository partnerContactRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public PartnerContactResponse createPartnerContact(ContactPRequest request) {
        Partner partner = partnerRepository.findById(request.getPartnerNum())
                .orElseThrow();
        ContactPartner contactPartner = modelMapper.map(request, ContactPartner.class);
        contactPartner.setPartner(partner);
        ContactPartner contactPartnerSaved = partnerContactRepository.save(contactPartner);
        return modelMapper.map(contactPartnerSaved, PartnerContactResponse.class);
    }

    @Override
    public List<PartnerContactResponse> getAllPartnerContacts() {
        List<ContactPartner> contactPartners = partnerContactRepository.findAll();
        List<PartnerContactResponse> partnerContactList = new ArrayList<>();

        for (ContactPartner contactPartner : contactPartners) {
            PartnerContactResponse response = modelMapper.map(contactPartner, PartnerContactResponse.class);
            partnerContactList.add(response);
        }
        return partnerContactList;
    }

    @Override
    public PartnerContactResponse getPartnerContactById(Long id) {
        ContactPartner contactPartner = partnerContactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("PartnerContact with id " +id+ " not found"));
        PartnerContactResponse partnerContactResponse = modelMapper.map(contactPartner, PartnerContactResponse.class);
        return partnerContactResponse;
    }

    @Override
    public List<PartnerContactResponse> findByPartnerId(Long id) {
        List<ContactPartner> contactPartnerList = partnerContactRepository.findByPartnerId(id);
        List<PartnerContactResponse> partnerContactList = new ArrayList<>();
        for (ContactPartner contactPartner : contactPartnerList) {
            PartnerContactResponse response = modelMapper.map(contactPartner, PartnerContactResponse.class);
            partnerContactList.add(response);
        }
        return partnerContactList;
    }

    @Override
    public PartnerContactResponse updatePartnerContact(Long id, ContactPRequest request) {
        ContactPartner existingContactPartner = partnerContactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("PartnerContact with id: " + id + " not found"));
        modelMapper.map(request, existingContactPartner);
        ContactPartner savedContactPartner = partnerContactRepository.save(existingContactPartner);
        return modelMapper.map(savedContactPartner, PartnerContactResponse.class);
    }

    @Override
    public void deletePartnerContact(Long id) {
        partnerContactRepository.deleteById(id);
    }
}
