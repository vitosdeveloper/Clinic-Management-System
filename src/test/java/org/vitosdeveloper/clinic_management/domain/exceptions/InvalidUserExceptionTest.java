package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidUserExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidUserException exception = new InvalidUserException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid User", exception.getMessage());
    }
}
