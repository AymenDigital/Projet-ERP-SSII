package com.csidigital.management.service;

import com.csidigital.shared.dto.request.AppointmentRequest;
import com.csidigital.dao.entity.Appointment;
import com.csidigital.shared.dto.request.AppointmentRequest;
import com.csidigital.shared.dto.response.AppointmentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    AppointmentResponse createAppointment(AppointmentRequest request);
    List<AppointmentResponse> getAllAppointments();
    AppointmentResponse getAppointmentById(Long id);

    AppointmentResponse updateAppointment(AppointmentRequest request, Long id);

    void deleteAppointment(Long id);
}
