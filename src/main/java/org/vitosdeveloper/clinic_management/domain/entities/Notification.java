package org.vitosdeveloper.clinic_management.domain.entities;

import org.springframework.util.StringUtils;
import org.vitosdeveloper.clinic_management.domain.exceptions.*;

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
        validateFields();
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

    private void validateFields() {
        if (this.id == null || id <= 0L) throw new InvalidIdException();
        if (!User.class.isInstance(recipient)) throw new InvalidUserException();
        if (message == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(message)))
            throw new InvalidMessageException();
        if (sentAt == null || !LocalDateTime.class.isInstance(sentAt)) throw new InvalidSentAtException();
    }
}
