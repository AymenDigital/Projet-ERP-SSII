package com.csidigital.shared.dto.request;

import lombok.Data;

@Data
public class BankAccountRequest {
    private Long rib;
    private Long bic;
    private Long iban;
    private String bankName;
    private String bankAddress;
    private Long partnerNum;
}
