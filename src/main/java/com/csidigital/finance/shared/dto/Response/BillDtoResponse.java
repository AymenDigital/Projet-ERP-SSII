package com.csidigital.finance.shared.dto.Response;

import com.csidigital.finance.dao.entity.AdditionalFee;
import com.csidigital.finance.dao.entity.Treasury;
import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.CurrencyAdditionalFees;
import com.csidigital.finance.shared.enumeration.InvoiceStatus;
import com.csidigital.finance.shared.enumeration.InvoiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
public class BillDtoResponse {
    private Long id;

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
