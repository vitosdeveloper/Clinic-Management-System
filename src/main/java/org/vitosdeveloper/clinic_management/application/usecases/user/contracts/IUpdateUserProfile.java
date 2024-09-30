package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

public interface IUpdateUserProfile {
    void execute(Long userId, String newEmail, String newPassword);
}
