package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.enums.Role;

public interface IRegisterUser {
    void execute(String email, String password, Role role);
}
