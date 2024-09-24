package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidSentAtExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidSentAtException exception = new InvalidSentAtException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid SentAt", exception.getMessage());
    }
}
