package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.shared.enumeration.TreasuryType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
@Data
@RequiredArgsConstructor
public class DisbursementDtoRequest {

    private String category;
    private String invoiceNumber ;
    private Long amount ;
    private Date date ;
    private String description;
    private TreasuryType treasuryType = TreasuryType.En_COURS;
    private Long billId;


}
