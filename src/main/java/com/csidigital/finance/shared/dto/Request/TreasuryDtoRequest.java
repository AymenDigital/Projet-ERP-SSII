package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.dao.entity.BankReconciliation;
import com.csidigital.finance.shared.enumeration.BankAccountType;
import com.csidigital.finance.shared.enumeration.CategoryCaisse;
import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.TreasuryType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class TreasuryDtoRequest {

    private Long amount ;
    private Date date;
    private String description ;
    private CategoryCaisse categoryCaisse;

}
