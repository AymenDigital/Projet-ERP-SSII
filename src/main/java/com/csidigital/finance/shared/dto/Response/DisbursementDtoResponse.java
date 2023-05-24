package com.csidigital.finance.shared.dto.Response;

import com.csidigital.finance.shared.enumeration.TreasuryType;
import lombok.Data;

import java.util.Date;
@Data
public class DisbursementDtoResponse {
    private Long id;
    private String category;
    private String invoiceNumber ;
    private Long amount ;
    private Date date ;    private String description;
    private String treasuryType;
    private BillDtoResponse bill;


}
