package com.csidigital.management.service;

import com.csidigital.shared.dto.request.AppointmentNoteRequest;
import com.csidigital.shared.dto.request.AppointmentRequest;
import com.csidigital.shared.dto.response.AppointmentNoteResponse;
import com.csidigital.shared.dto.response.AppointmentResponse;

import java.util.List;

public interface AppointmentNoteService {
    AppointmentNoteResponse createAppointmentNote(AppointmentNoteRequest request);
    List<AppointmentNoteResponse> getAllAppointmentNotes();
    AppointmentNoteResponse getAppointmentNoteById(Long id);

    AppointmentNoteResponse updateAppointmentNote(AppointmentNoteRequest request, Long id);

    void deleteAppointmentNote(Long id);
}