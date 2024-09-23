package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidDoctorException extends RuntimeException {
    public InvalidDoctorException() {
        super("Invalid Doctor");
    }
}
