package org.vitosdeveloper.clinic_management.application.usecases.appointment.implementations;

import org.vitosdeveloper.clinic_management.application.exceptions.AppointmentNotFoundException;
import org.vitosdeveloper.clinic_management.application.usecases.appointment.contracts.IRescheduleAppointment;
import org.vitosdeveloper.clinic_management.domain.entities.Appointment;
import org.vitosdeveloper.clinic_management.domain.repositories.IAppointmentRepository;

import java.time.LocalDateTime;

public class RescheduleAppointment implements IRescheduleAppointment {
    IAppointmentRepository appointmentRepository;

    public RescheduleAppointment(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public void execute(Long appointmentId, LocalDateTime newTime) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(AppointmentNotFoundException::new);
        if (newTime.isBefore(LocalDateTime.now())) throw new RuntimeException();
        appointment.setAppointmentDate(newTime);
        appointmentRepository.save(appointment);
    }
}
