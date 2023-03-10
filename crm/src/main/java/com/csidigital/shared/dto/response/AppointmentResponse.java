package com.csidigital.shared.dto.response;

import com.csidigital.dao.entity.Contact;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentResponse {
    private Long Id ;
    private LocalDate date;
    private LocalTime time;
    private Duration duration;
    private String subject;
    private Contact contact;
}
