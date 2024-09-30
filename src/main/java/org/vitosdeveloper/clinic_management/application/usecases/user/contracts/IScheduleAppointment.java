package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import java.time.LocalDateTime;

public interface IScheduleAppointment {
    void execute(Long doctorId, Long patientId, LocalDateTime appointmentTime);
}
