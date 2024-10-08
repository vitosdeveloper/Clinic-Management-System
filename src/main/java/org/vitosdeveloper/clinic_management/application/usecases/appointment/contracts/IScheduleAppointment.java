package org.vitosdeveloper.clinic_management.application.usecases.appointment.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Appointment;

import java.time.LocalDateTime;

public interface IScheduleAppointment {
    Appointment execute(Long doctorId, Long patientId, LocalDateTime appointmentTime, String reason);
}
