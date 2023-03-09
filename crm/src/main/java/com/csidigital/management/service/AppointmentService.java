package com.csidigital.management.service;

import com.csidigital.shared.dto.request.AppointmentRequest;
import com.csidigital.dao.entity.Appointment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment create(Appointment appointment);
    List<Appointment> get();
    Optional<Appointment> getById(Long id);

    ResponseEntity<Appointment> update(AppointmentRequest appointmentRequest , Long id );

    void delete(Long id);
}
