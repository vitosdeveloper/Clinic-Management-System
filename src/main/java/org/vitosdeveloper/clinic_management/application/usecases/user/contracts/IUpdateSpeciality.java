package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

public interface IUpdateSpeciality {
    void execute(Long specialityId, String newName);
}
