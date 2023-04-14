package com.csidigital.finance.shared.dto.Response;

import java.util.Date;

import com.csidigital.finance.dao.entity.Treasury;
import com.csidigital.finance.shared.enumeration.Currency;
import lombok.Data;


@Data
public class BankReconciliationDtoResponse {
    private Long id;

    private Long checkNumber;

    private Date issueDate;

    private double Amount;

    private String beneficiary;

    private Long InvoiceNumber;

    private Date CompletionDate;

    private Currency currency;

    private  Long treasuryId ;
}
