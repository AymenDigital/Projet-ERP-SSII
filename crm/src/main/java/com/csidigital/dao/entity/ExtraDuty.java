package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.ExtraDutyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExtraDuty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long workingHoursNumber ;
    private double HourWage ;
    private double PerformanceBonus ;
    private ExtraDutyType extraDuty ;

    @ManyToOne
    private Benefit benefit;
}
