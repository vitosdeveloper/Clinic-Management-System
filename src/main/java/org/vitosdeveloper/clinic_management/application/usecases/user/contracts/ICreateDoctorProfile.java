package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Speciality;

public interface ICreateDoctorProfile {
    void execute(String name, String crm, Speciality speciality);
}
