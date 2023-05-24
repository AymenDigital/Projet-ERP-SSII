package com.csidigital.finance.shared.dto.Response;



import com.csidigital.finance.shared.enumeration.CategoryCaisse;
import com.csidigital.finance.shared.enumeration.TreasuryType;
import lombok.Data;

import java.util.Date;


@Data
public class TreasuryDtoResponse {
    private Long id;

    private Long amount;
    private Date date;
    private String description ;
    private CategoryCaisse categoryCaisse;

}
