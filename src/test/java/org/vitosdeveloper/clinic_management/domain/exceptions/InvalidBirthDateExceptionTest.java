package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidBirthDateExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidBirthDateException exception = new InvalidBirthDateException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid BirthDate", exception.getMessage());
    }
}
