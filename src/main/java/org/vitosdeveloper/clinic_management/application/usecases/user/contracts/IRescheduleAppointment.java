package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import java.time.LocalDateTime;

public interface IRescheduleAppointment {
    void execute(Long appointmentId, LocalDateTime newTime);
}
