package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidReasonException extends RuntimeException {
    public InvalidReasonException() {
        super("Invalid reason, it should have at least 3 characters");
    }
}
