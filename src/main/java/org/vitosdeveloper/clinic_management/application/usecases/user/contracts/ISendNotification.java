package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

public interface ISendNotification {
    void execute(Long userId, String message);
}
