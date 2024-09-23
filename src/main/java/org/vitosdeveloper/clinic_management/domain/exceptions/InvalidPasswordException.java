package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("Invalid password. Should have at least 6 characters.");
    }
}
