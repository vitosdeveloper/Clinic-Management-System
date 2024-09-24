package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidAppointmentException extends RuntimeException {
    public InvalidAppointmentException() {
        super("Invalid Appointment");
    }
}
