package org.vitosdeveloper.clinic_management.application.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long patientId) {
        super("Patient with ID " + patientId + " not found.");
    }
}
