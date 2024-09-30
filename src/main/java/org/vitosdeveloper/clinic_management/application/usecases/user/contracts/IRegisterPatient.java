package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

public interface IRegisterPatient {
    void execute(String name, String email);
}
