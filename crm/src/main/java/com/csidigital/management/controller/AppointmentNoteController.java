package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.AppointmentNoteServiceImpl;
import com.csidigital.management.service.implementation.AppointmentServiceImpl;
import com.csidigital.shared.dto.request.AppointmentNoteRequest;
import com.csidigital.shared.dto.request.AppointmentRequest;
import com.csidigital.shared.dto.response.AppointmentNoteResponse;
import com.csidigital.shared.dto.response.AppointmentResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crm/appointmentNotes")
@CrossOrigin("*")
public class AppointmentNoteController {
    @Autowired
    private AppointmentNoteServiceImpl appointmentNoteService;

    @GetMapping()
    public List<AppointmentNoteResponse> getAllAppointmentNotes() {
        return appointmentNoteService.getAllAppointmentNotes();
    }

    @GetMapping("/{id}")
    public AppointmentNoteResponse getAppointmentNoteById(@PathVariable Long id){
        return appointmentNoteService.getAppointmentNoteById(id);
    }

    @PostMapping()
    public AppointmentNoteResponse createAppointmentNote(@Valid @RequestBody AppointmentNoteRequest request){
        return appointmentNoteService.createAppointmentNote(request);
    }

    @PutMapping("/{id}")
    public AppointmentNoteResponse updateAppointmentNote(@Valid @RequestBody AppointmentNoteRequest request,
                                                 @PathVariable Long id){
        return appointmentNoteService.updateAppointmentNote(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        appointmentNoteService.deleteAppointmentNote(id);
    }
}
