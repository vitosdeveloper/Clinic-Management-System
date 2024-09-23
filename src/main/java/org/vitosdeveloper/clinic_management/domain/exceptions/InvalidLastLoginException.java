package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidLastLoginException extends RuntimeException {
    public InvalidLastLoginException() {
        super("Invalid lastLogin");
    }
}
