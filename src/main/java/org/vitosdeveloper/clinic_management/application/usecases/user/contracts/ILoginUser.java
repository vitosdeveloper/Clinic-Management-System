package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.User;

public interface ILoginUser {
    User execute(String email, String password);
}
