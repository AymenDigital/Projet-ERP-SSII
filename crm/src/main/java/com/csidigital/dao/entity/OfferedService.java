package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.ServiceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OfferedService {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title ;
    private ServiceType serviceType ;

    @ManyToOne
    private Partner partner;
}
