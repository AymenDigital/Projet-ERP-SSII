package com.csidigital.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ContactPartner extends Contact{
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Partner partner ;
}
