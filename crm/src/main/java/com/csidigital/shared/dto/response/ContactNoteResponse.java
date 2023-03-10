package com.csidigital.shared.dto.response;

import com.csidigital.dao.entity.Contact;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContactNoteResponse {
    private Long id ;
    private LocalDate contactDate;
    private String  subject;
    private String comment;
    private String discussionNote;
    private String duration;

    private Contact contact;
}
