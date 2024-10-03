package org.vitosdeveloper.clinic_management.application.usecases.speciality.contracts;

public interface IUpdateSpeciality {
    void execute(Long specialityId, String newName);
}
