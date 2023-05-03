package com.csidigital.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ContactIndepBankAccount extends BankAccount implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ContactIndep contactIndep;
}
