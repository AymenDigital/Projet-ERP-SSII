package com.csidigital.shared.dto.response;

import com.csidigital.dao.entity.ContactIndep;
import lombok.Data;

@Data
public class ContactIndepBankAccountResponse {
    private Long id;
    private Long rib;
    private String bankName;
    private Long contactIndepId;
}
