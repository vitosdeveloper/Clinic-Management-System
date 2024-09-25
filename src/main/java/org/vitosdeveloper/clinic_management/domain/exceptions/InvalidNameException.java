package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException() {
        super("Invalid Name");
    }
}
