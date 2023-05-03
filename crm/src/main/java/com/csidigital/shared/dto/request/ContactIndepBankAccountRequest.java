package com.csidigital.shared.dto.request;

import lombok.Data;

@Data
public class ContactIndepBankAccountRequest {
    private Long rib;
    private String bankName;
    private Long contactIndepNum;
}
