package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Appointment;
import com.csidigital.dao.repository.AppointmentRepository;
import com.csidigital.shared.dto.request.AppointmentRequest;
import com.csidigital.dao.entity.Appointment;
import com.csidigital.shared.dto.request.AppointmentRequest;
import com.csidigital.shared.dto.response.AppointmentResponse;
import com.csidigital.shared.exceptions.ResourceNotFoundException;
import com.csidigital.dao.repository.AppointmentRepository;
import com.csidigital.management.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AppointmentResponse createAppointment(AppointmentRequest request) {
        Appointment appointment = modelMapper.map(request, Appointment.class);
        Appointment appointmentSaved = appointmentRepository.save(appointment);
        return modelMapper.map(appointmentSaved, AppointmentResponse.class);
    }

    @Override
    public List<AppointmentResponse> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentResponse> appointmentList = new ArrayList<>();

        for (Appointment appointment : appointments) {
            AppointmentResponse response = modelMapper.map(appointment, AppointmentResponse.class);
            appointmentList.add(response);
        }

        return appointmentList;
    }

    @Override
    public AppointmentResponse getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Appointment with id " +id+ " not found"));
        AppointmentResponse appointmentResponse = modelMapper.map(appointment, AppointmentResponse.class);
        return appointmentResponse;
    }

    @Override
    public AppointmentResponse updateAppointment(AppointmentRequest request, Long id) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Appointment with id: " + id + " not found"));
        modelMapper.map(request, existingAppointment);
        Appointment savedAppointment = appointmentRepository.save(existingAppointment);
        return modelMapper.map(savedAppointment, AppointmentResponse.class);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
