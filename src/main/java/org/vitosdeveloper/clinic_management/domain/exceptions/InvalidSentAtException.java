package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidSentAtException extends RuntimeException {
    public InvalidSentAtException() {
        super("Invalid SentAt");
    }
}