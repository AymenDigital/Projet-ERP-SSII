package com.csidigital.finance.management.service;

import com.csidigital.finance.shared.dto.Request.BillClientDtoRequest;
import com.csidigital.finance.shared.dto.Request.BillDtoRequest;
import com.csidigital.finance.shared.dto.Response.BillClientDtoResponse;
import com.csidigital.finance.shared.dto.Response.BillDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillClientService {
    //Get All BillClient

    List<BillClientDtoResponse> getAllBillClients();

    //Get BillClient by id

    BillClientDtoResponse getBillClientById(Long id);
    //Add new BillClient

    BillClientDtoResponse CreateBillClient(BillClientDtoRequest billClientDtoRequest);

    //Update BillClient by id
    BillClientDtoResponse updateBillClient(BillClientDtoRequest billClientDtoRequest, Long id);

    //delete BillClient by id
    void deleteBillClientById(Long id);
}
