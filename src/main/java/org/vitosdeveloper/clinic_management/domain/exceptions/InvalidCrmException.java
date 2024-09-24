package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidCrmException extends RuntimeException {
    public InvalidCrmException() {
        super("Invalid Crm");
    }
}
