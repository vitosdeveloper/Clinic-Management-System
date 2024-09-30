package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Doctor;

public interface IGetDoctorProfile {
    Doctor execute(Long doctorId);
}
