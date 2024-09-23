package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvalidEmailExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidEmailException exception = new InvalidEmailException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid email", exception.getMessage());
    }
}
