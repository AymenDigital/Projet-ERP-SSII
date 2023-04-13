package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.dao.entity.AdditionalFee;
import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.CurrencyAdditionalFees;
import com.csidigital.finance.shared.enumeration.InvoiceStatus;
import com.csidigital.finance.shared.enumeration.InvoiceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class BillDtoRequest {
    private Integer invoiceNumber;

    private Date date;

    private String nameSeller;

    private String addressSeller;

    private String nameBuyer;

    private String addressBuyer;

    private Integer discount ;

    private InvoiceStatus InvoiceStatus;

    private Currency Currency;

    private Long treasuryId ;

    private List<AdditionalFee> additionalFees ;
}

