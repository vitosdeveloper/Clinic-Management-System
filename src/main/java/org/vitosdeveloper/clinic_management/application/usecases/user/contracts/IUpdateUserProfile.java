package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.User;

public interface IUpdateUserProfile {
    User execute(Long userId, String newEmail, String newPassword);
}
