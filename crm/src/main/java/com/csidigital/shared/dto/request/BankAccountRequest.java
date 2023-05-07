package com.csidigital.shared.dto.request;

import lombok.Data;

@Data
public class BankAccountRequest {
    private Long rib;
    private String bankName;
    private Long partnerNum;
}
