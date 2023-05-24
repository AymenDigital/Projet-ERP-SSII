package com.csidigital.finance.shared.dto.Response;

import com.csidigital.finance.dao.entity.AdditionalFee;
import com.csidigital.finance.dao.entity.Bill;
import com.csidigital.finance.shared.enumeration.TreasuryType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CollectionDtoResponse {
    private Long id;
    private String category ;
    private String invoiceNumber ;
    private Long amount ;
    private Date date ;
    private String description ;
    private TreasuryType treasuryType;
    private BillClientDtoResponse billClient;


}
