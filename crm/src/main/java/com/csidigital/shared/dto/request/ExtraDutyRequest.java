package com.csidigital.shared.dto.request;


import com.csidigital.dao.entity.Benefit;
import com.csidigital.shared.enumeration.ExtraDutyType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data

public class ExtraDutyRequest {
    private Long workingHoursNumber ;
    private Double hourWage ;
    private Double performanceBonus ;

    private ExtraDutyType extraDutyType ;


    private Long benefitNum;
}
