package com.csidigital.shared.dto.response;

import lombok.Data;

@Data
public class BankAccountResponse {
    private Long id;
    private Long rib;
    private Long bic;
    private Long iban;
    private String bankName;
    private String bankAddress;
    private Long partnerId;
}
