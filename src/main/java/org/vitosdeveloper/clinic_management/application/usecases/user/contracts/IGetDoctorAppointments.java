package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Appointment;

import java.util.List;

public interface IGetDoctorAppointments {
    List<Appointment> execute(Long doctorId);
}
