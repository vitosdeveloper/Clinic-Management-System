package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

public interface IUpdatePatientProfile {
    void execute(Long patientId, String newName, String newEmail);
}
