package org.vitosdeveloper.clinic_management.domain.repositories;

import org.vitosdeveloper.clinic_management.domain.entities.Appointment;

import java.time.LocalDateTime;

public interface IAppointmentRepository extends IGenericRepository<Appointment> {
    boolean isAppointmentSlotTaken(Long doctorId, LocalDateTime appointmentTime);
}
