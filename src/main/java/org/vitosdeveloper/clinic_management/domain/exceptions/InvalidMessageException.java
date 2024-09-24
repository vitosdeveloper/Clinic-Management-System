package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidMessageException extends RuntimeException {
    public InvalidMessageException() {
        super("Invalid Message");
    }
}