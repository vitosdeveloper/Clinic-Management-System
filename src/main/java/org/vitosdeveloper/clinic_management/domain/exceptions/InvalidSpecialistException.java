package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidSpecialistException extends RuntimeException {
    public InvalidSpecialistException() {
        super("Invalid Speciality");
    }
}
