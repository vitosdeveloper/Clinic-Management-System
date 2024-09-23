package org.vitosdeveloper.clinic_management.domain.entities;

import java.time.LocalDateTime;

public class Notification {
    private final Long id;
    private final User recipient;
    private final String message;
    private final LocalDateTime sentAt;

    public Notification(String message, Long id, User recipient, LocalDateTime sentAt) {
        this.message = message;
        this.id = id;
        this.recipient = recipient;
        this.sentAt = sentAt;
    }

    public Long getId() {
        return id;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
