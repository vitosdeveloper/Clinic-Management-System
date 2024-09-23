package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidLastLoginExceptionTest {
    @Test
    void testInvalidLastLoginException() {
        InvalidLastLoginException exception = new InvalidLastLoginException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid lastLogin", exception.getMessage());
    }
}
