package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidBirthDateException extends RuntimeException {
    public InvalidBirthDateException() {
        super("Invalid BirthDate");
    }
}
