package com.csidigital.finance.management.service;

import com.csidigital.finance.shared.dto.Request.BillDtoRequest;
import com.csidigital.finance.shared.dto.Response.BillDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    //Get All Bill

    List<BillDtoResponse> getAllBills();

    //Get Bill by id

    BillDtoResponse getBillById(Long id);
    //Add new Bill

    BillDtoResponse CreateBill(BillDtoRequest billDtoRequest);

    //Update Bill by id
    BillDtoResponse updateBill(BillDtoRequest billDtoRequest, Long id);

    //delete Bill by id
    void deleteBillById(Long id);


}
