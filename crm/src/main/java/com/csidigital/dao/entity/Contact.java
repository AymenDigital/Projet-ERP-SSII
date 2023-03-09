package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.Civility;
import com.csidigital.shared.enumeration.Privilege;
import com.csidigital.shared.enumeration.Service;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Civility civility;
    private String lastName;
    private String firstName;
    private String function;
    @Enumerated(EnumType.STRING)
    private Service service;
    private String emailOne;
    private String emailTwo;
    private Long phoneNumberOne;
    private Long phoneNumberTwo;
    private String comment;
    @Enumerated(EnumType.STRING)
    private Privilege privilege;

    @OneToMany(mappedBy = "contact")
    private List<ContactNote> contactNotes;

    @OneToMany(mappedBy = "contact")
    private List<Appointment> appointments;

}
