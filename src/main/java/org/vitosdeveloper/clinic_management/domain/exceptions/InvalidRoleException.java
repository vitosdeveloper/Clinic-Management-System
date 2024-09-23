package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidRoleException extends RuntimeException {
    public InvalidRoleException() {
        super("Invalid role");
    }
}
