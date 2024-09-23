package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidAppointmentDateException extends RuntimeException {
    public InvalidAppointmentDateException() {
        super("Invalid AppointmentDate");
    }
}
