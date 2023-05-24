package com.csidigital.finance.management.service;

import com.csidigital.finance.shared.dto.Request.AdditionalFeeDtoRequest;
import com.csidigital.finance.shared.dto.Response.AdditionalFeeDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdditionalFeeService {
    //Get All Additional

    List<AdditionalFeeDtoResponse<Number>> getAllAdditionalFee();

    //Get AdditionalFee by id

    AdditionalFeeDtoResponse<Number> getAdditionalFeeById(Long id);
    //Add new AdditionalFee
    List<AdditionalFeeDtoResponse<Number>> CreateAdditionalFee(List<AdditionalFeeDtoRequest> additionalFeeDtoRequests);

    //Update AdditionalFee by id
    AdditionalFeeDtoResponse<Number> updateAdditionalFee(AdditionalFeeDtoRequest additionalFeeDtoRequest, Long id);

   //delete AdditionalFee by id
   void deleteAdditionalFeeById(Long id);


}
