package com.csidigital.shared.dto.request;

import com.csidigital.dao.entity.Appointment;
import com.csidigital.dao.entity.ContactNote;
import com.csidigital.shared.enumeration.Civility;
import com.csidigital.shared.enumeration.Privilege;
import com.csidigital.shared.enumeration.Service;
import lombok.Data;

import java.util.List;

@Data
public class ContactRequest {
    private Civility civility;
    private String lastName;
    private String firstName;
    private String function;
    private String societe;
    private String service;
    private String emailOne;
    private String emailTwo;
    private Long phoneNumberOne;
    private Long phoneNumberTwo;
    private String comment;
    private Privilege privilege;
    private List<ContactNote> contactNotes;
    private List<Appointment> appointments;
    private Long partnerNum ;
}
