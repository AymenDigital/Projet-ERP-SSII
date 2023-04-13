package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.dao.entity.Treasury;
import com.csidigital.finance.shared.enumeration.Currency;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class BankReconciliationDtoRequest {
    private Long checkNumber;

    private Date issueDate;

    private double Amount;

    private String beneficiary;

    private Long InvoiceNumber;

    private Date CompletionDate;

    private Currency currency;

    private  Long treasuryId ;
}
