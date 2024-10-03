package org.vitosdeveloper.clinic_management.application.usecases.patient.contracts;

public interface IUpdatePatientProfile {
    void execute(Long patientId, String newName, String newEmail);

    interface IRegisterPatient {
        void execute(String name, String email);
    }
}
