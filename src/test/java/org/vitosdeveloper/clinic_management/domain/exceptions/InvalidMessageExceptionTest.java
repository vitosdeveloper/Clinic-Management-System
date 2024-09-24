package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidMessageExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidMessageException exception = new InvalidMessageException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Message", exception.getMessage());
    }
}
