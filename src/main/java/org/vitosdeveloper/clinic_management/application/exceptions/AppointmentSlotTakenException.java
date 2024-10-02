package org.vitosdeveloper.clinic_management.application.exceptions;

import java.time.LocalDateTime;

public class AppointmentSlotTakenException extends RuntimeException {
    public AppointmentSlotTakenException(LocalDateTime appointmentDate) {
        super("Appointment slot for " + appointmentDate + " is already taken.");
    }
}
