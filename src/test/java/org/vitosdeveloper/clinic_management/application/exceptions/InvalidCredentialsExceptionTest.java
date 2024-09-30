package org.vitosdeveloper.clinic_management.application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidCredentialsExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidCredentialsException exception = new InvalidCredentialsException();
        assertInstanceOf(InvalidCredentialsException.class, exception);
        assertEquals("Invalid Credentials", exception.getMessage());
    }
}
