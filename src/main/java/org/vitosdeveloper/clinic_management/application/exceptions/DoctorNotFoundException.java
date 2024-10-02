package org.vitosdeveloper.clinic_management.application.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(Long doctorId) {
        super("Doctor with ID " + doctorId + " not found.");
    }
}
