package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidPatientException extends RuntimeException {
    public InvalidPatientException() {
        super("Invalid Patient");
    }
}
