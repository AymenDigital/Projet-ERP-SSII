package com.csidigital.shared.dto.response;

import com.csidigital.dao.entity.Contact;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentResponse {
    private Long Id ;
    private LocalDate date;
    private LocalTime time;

    private String duration;
    private String subject;


    private Contact contact;
}
