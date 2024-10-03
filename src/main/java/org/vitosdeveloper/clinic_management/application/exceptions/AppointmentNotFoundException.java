package org.vitosdeveloper.clinic_management.application.exceptions;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException() {
        super("Appointment not found.");
    }
}
