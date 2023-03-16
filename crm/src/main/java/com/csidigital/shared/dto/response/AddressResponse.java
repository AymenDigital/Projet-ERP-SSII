package com.csidigital.shared.dto.response;

import com.csidigital.dao.entity.Partner;
import lombok.Data;

@Data
public class AddressResponse {
   private  Long Id ;
   private String addressTitle ;
   private Long partnerId;
}
