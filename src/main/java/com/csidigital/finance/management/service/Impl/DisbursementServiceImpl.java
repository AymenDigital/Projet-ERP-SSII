package com.csidigital.finance.management.service.Impl;

import com.csidigital.finance.dao.entity.Bill;
import com.csidigital.finance.dao.entity.BillClient;
import com.csidigital.finance.dao.entity.Collection;
import com.csidigital.finance.dao.entity.Disbursement;
import com.csidigital.finance.dao.repository.DisbursementRepository;
import com.csidigital.finance.management.service.DisbursementService;
import com.csidigital.finance.shared.dto.Request.CollectionDtoRequest;
import com.csidigital.finance.shared.dto.Request.DisbursementDtoRequest;
import com.csidigital.finance.shared.dto.Response.CollectionDtoResponse;
import com.csidigital.finance.shared.dto.Response.DisbursementDtoResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service

public class DisbursementServiceImpl implements DisbursementService {



        @Autowired
        private ModelMapper modelMapper;
        @Autowired
        private DisbursementRepository disbursementRepository;

        @Override
        public List<DisbursementDtoResponse> getAllDisbursement() {
                List<Disbursement> disbursements = disbursementRepository.findAll();
                List<DisbursementDtoResponse> disbursementList = new ArrayList<>();

                for (Disbursement disbursement : disbursements) {
                        DisbursementDtoResponse disbursementDtoResponse = modelMapper.map(disbursement, DisbursementDtoResponse.class);
                        disbursementList.add(disbursementDtoResponse);
                }

                return disbursementList;
        }

        @Override
        public DisbursementDtoResponse getByIdDisbursement(Long id) {
                Disbursement disbursement= disbursementRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Disbursement with id " +id+ " not found"));
                DisbursementDtoResponse disbursementDtoResponse = modelMapper.map(disbursement, DisbursementDtoResponse.class);
                return disbursementDtoResponse;
        }

        @Override
        public DisbursementDtoResponse CreateDisbursement(DisbursementDtoRequest disbursementDtoRequest) {
                Disbursement disbursement = modelMapper.map(disbursementDtoRequest, Disbursement.class);
                Disbursement DisbursementSaved = disbursementRepository.save(disbursement);
                return modelMapper.map(DisbursementSaved,DisbursementDtoResponse.class);
        }

        @Override
        public DisbursementDtoResponse updateDisbursement(@Valid DisbursementDtoRequest request, Long id) {
                Disbursement existingDisbursement = disbursementRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Disbursement with id: " + id + " not found"));

                // Conserver la référence du billClient existant
                Bill bill = existingDisbursement.getBill();

                // Effectuer la mise à jour des attributs de la collection
                existingDisbursement.setCategory(request.getCategory());
                existingDisbursement.setInvoiceNumber(request.getInvoiceNumber());
                existingDisbursement.setAmount(request.getAmount());
                existingDisbursement.setDate(request.getDate());
                existingDisbursement.setDescription(request.getDescription());
                existingDisbursement.setTreasuryType(request.getTreasuryType());

                // Rétablir la référence du billClient existant
                existingDisbursement.setBill(bill);

                Disbursement savedDisbursement = disbursementRepository.save(existingDisbursement);
                return modelMapper.map(savedDisbursement, DisbursementDtoResponse.class);
        }

        @Override
        public void deleteDisbursementById(Long id) {
                {disbursementRepository.deleteById(id);}

        }
}
