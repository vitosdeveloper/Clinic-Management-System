package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidSpecialistyException extends RuntimeException {
    public InvalidSpecialistyException() {
        super("Invalid Speciality");
    }
}
