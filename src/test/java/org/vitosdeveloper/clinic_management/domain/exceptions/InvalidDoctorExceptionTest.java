package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidDoctorExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidDoctorException exception = new InvalidDoctorException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Doctor", exception.getMessage());
    }
}
