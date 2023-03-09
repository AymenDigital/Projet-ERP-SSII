package com.csidigital.management.service.implementation;

import com.csidigital.shared.dto.request.AppointmentRequest;
import com.csidigital.dao.entity.Appointment;
import com.csidigital.shared.exceptions.ResourceNotFoundException;
import com.csidigital.dao.repository.AppointmentRepository;
import com.csidigital.management.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository ;
    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> get() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public ResponseEntity<Appointment> update(AppointmentRequest appointmentRequest, Long id) {
        Appointment app = appointmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("appointment with id " +id+ " not found"));
        app.setContact(appointmentRequest.getContact());
        app.setDate(appointmentRequest.getDate());
        app.setDuration(appointmentRequest.getDuration());
        app.setSubject(appointmentRequest.getSubject());
        appointmentRepository.save(app);
        return ResponseEntity.ok(app);
    }

    @Override
    public void delete(Long id) {
appointmentRepository.deleteById(id);
    }
}
