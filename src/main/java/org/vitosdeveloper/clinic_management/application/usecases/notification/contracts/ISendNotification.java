package org.vitosdeveloper.clinic_management.application.usecases.notification.contracts;

public interface ISendNotification {
    void execute(Long userId, String message);
}
