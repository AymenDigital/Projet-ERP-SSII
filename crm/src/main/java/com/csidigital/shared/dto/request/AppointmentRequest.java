package com.csidigital.shared.dto.request;

import com.csidigital.dao.entity.AppointmentNote;
import com.csidigital.dao.entity.Contact;

import lombok.Data;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data

public class AppointmentRequest {
    private LocalDate date;
    private LocalTime time;
    private Long duration;
    private String location;
    private String subject;
    private String feedBack;
    private List<AppointmentNote> appointmentNotes;
    private Long contactNum;
}