package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidStatusException extends RuntimeException {
    public InvalidStatusException() {
        super("Invalid Status");
    }
}
