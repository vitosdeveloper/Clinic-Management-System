package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidPatientExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidPatientException exception = new InvalidPatientException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Patient", exception.getMessage());
    }
}
