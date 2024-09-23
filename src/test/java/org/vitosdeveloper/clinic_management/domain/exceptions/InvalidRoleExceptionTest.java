package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidRoleExceptionTest {
    @Test
    void testInvalidRoleException() {
        InvalidRoleException exception = new InvalidRoleException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid role", exception.getMessage());
    }
}
