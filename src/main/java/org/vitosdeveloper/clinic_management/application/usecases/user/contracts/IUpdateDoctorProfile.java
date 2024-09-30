package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Speciality;

public interface IUpdateDoctorProfile {
    void execute(Long doctorId, String newName, String newCrm, Speciality newSpeciality);
}
