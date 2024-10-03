package org.vitosdeveloper.clinic_management.application.usecases.appointment.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Appointment;

public interface IGetAppointmentDetails {
    Appointment execute(Long appointmentId);
}
