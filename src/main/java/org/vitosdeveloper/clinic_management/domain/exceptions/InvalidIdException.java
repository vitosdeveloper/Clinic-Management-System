package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
        super("Invalid id");
    }
}
