package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.dao.entity.BankReconciliation;
import com.csidigital.finance.dao.entity.Bill;
import com.csidigital.finance.dao.entity.Category;
import com.csidigital.finance.shared.enumeration.BankAccountType;
import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.TreasuryType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class TreasuryDtoRequest {
    private String description;
    private Double Amount;
    private Date date;
    private Double total;
    private TreasuryType treasuryType;
    private BankAccountType bankAccountType;
    private Currency currency;
    private List<Bill> bills;
    private List<Category> categories;
    private List<BankReconciliation> bankReconciliations;
}
