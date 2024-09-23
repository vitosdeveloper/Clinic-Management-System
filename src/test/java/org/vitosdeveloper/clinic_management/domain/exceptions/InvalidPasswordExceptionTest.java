package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidPasswordExceptionTest {
    @Test
    void testInvalidPasswordException() {
        InvalidPasswordException exception = new InvalidPasswordException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid password", exception.getMessage());
    }
}
