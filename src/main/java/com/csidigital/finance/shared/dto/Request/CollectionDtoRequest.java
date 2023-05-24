package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.dao.entity.Bill;
import com.csidigital.finance.shared.enumeration.TreasuryType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class CollectionDtoRequest {
    private String category ;
    private String invoiceNumber ;
    private Long amount ;
    private Date date ;
    private String description ;
    private TreasuryType treasuryType = TreasuryType.En_COURS;
    private Long billClientId;


}
