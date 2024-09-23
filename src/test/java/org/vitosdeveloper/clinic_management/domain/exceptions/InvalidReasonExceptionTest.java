package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidReasonExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidReasonException exception = new InvalidReasonException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid reason, it should have at least 3 characters", exception.getMessage());
    }
}
