package org.vitosdeveloper.clinic_management.application.usecases.doctor.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Appointment;

import java.util.List;

public interface IGetDoctorAppointments {
    List<Appointment> execute(Long doctorId);
}
