package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidSpecialistExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidSpecialistException exception = new InvalidSpecialistException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Speciality", exception.getMessage());
    }
}
