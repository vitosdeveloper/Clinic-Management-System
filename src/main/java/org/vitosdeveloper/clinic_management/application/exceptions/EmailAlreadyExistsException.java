package org.vitosdeveloper.clinic_management.application.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Email " + email + " is already in use.");
    }
}
