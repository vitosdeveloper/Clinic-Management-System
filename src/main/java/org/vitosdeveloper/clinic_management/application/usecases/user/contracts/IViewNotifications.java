package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

import org.vitosdeveloper.clinic_management.domain.entities.Notification;

import java.util.List;

public interface IViewNotifications {
    List<Notification> execute(Long userId);
}
