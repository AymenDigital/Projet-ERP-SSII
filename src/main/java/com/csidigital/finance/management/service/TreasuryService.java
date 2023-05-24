package com.csidigital.finance.management.service;


import com.csidigital.finance.shared.dto.Request.TreasuryDtoRequest;
import com.csidigital.finance.shared.dto.Response.TreasuryDtoResponse;

import java.util.List;

public interface TreasuryService {
    //Get All Treasury

    List<TreasuryDtoResponse> getAllTreasury();

    //Get Treasury by id

    TreasuryDtoResponse getTreasuryById(Long id);

    //Add new Treasury

    TreasuryDtoResponse CreateTreasury(TreasuryDtoRequest treasuryDtoRequest);

    //Update Treasury by id
    TreasuryDtoResponse updateTreasury(TreasuryDtoRequest treasuryDtoRequest, Long id);

    //delete Treasury by id
    void deleteTreasuryById(Long id);



}
