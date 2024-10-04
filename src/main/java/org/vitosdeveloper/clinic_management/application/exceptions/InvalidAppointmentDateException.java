package org.vitosdeveloper.clinic_management.application.exceptions;

public class InvalidAppointmentDateException extends RuntimeException {
    public InvalidAppointmentDateException() {
        super("The appointment date is invalid.");
    }
}
