package com.csidigital.shared.dto.request;


import com.csidigital.dao.entity.Partner;
import lombok.Data;


@Data

public class AddressRequest {
    private String addressTitle ;
    private Long partnerNum;
}
