package org.vitosdeveloper.clinic_management.application.usecases.doctor.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Doctor;

public interface IGetDoctorProfile {
    Doctor execute(Long doctorId);
}
