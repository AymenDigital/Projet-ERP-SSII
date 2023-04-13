package com.csidigital.finance.management.service.Impl;

import com.csidigital.finance.dao.entity.AdditionalFee;
import com.csidigital.finance.dao.entity.Bill;
import com.csidigital.finance.dao.entity.Treasury;
import com.csidigital.finance.dao.repository.BillRepository;
import com.csidigital.finance.dao.repository.TreasuryRepository;
import com.csidigital.finance.management.service.BillService;
import com.csidigital.finance.shared.dto.Request.BillDtoRequest;
import com.csidigital.finance.shared.dto.Response.BillDtoResponse;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private TreasuryRepository treasuryRepository ;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BillDtoResponse> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        List<BillDtoResponse> billList = new ArrayList<>();

        for (Bill bill : bills) {
            BillDtoResponse billResponse = modelMapper.map(bill, BillDtoResponse.class);
            billList.add(billResponse);
        }

        return billList;
    }

    @Override
    public BillDtoResponse getBillById(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bill with id " +id+ " not found"));
        BillDtoResponse billDtoResponse = modelMapper.map(bill, BillDtoResponse.class);
        return billDtoResponse;
    }

    @Override
    public BillDtoResponse CreateBill(BillDtoRequest billDtoRequest) {
        Bill bill = modelMapper.map(billDtoRequest, Bill.class);
        Treasury treasury = treasuryRepository.findById(billDtoRequest.getTreasuryId()).orElseThrow();
        bill.setTreasury(treasury);
        Bill BillSaved = billRepository.save(bill);
        return modelMapper.map(BillSaved, BillDtoResponse.class);
    }

    @Override
    public BillDtoResponse updateBill(BillDtoRequest billDtoRequest, Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bill with id: " + id + " not found"));
        modelMapper.map(billDtoRequest, bill);
        Bill updatedBill = billRepository.save(bill);
        return modelMapper.map(updatedBill, BillDtoResponse.class);

    }

    @Override
    public void deleteBillById(Long id) {
        billRepository.deleteById(id);

    }



}
