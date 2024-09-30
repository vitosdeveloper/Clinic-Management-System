package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Patient;

public interface IGetPatientProfile {
    Patient execute(Long patientId);
}
