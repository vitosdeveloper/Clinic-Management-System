package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Invalid email");
    }
}
