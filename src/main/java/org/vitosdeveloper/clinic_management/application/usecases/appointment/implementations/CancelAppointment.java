package org.vitosdeveloper.clinic_management.application.usecases.appointment.implementations;

import org.vitosdeveloper.clinic_management.application.usecases.appointment.contracts.ICancelAppointment;
import org.vitosdeveloper.clinic_management.domain.entities.Appointment;
import org.vitosdeveloper.clinic_management.domain.enums.Status;
import org.vitosdeveloper.clinic_management.domain.repositories.IAppointmentRepository;

public class CancelAppointment implements ICancelAppointment {
    IAppointmentRepository appointmentRepository;

    public CancelAppointment(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void execute(Long appointmentId) {
        Appointment appointment = this.appointmentRepository
                .findById(appointmentId).orElseThrow(() -> new RuntimeException(""));
        appointment.setStatus(Status.CANCELED);
        this.appointmentRepository.save(appointment);
    }
}
