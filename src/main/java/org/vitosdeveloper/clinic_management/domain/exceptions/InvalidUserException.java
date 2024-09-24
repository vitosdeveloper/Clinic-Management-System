package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException() {
        super("Invalid User");
    }
}