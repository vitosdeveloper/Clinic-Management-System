package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidAppointmentExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidAppointmentException exception = new InvalidAppointmentException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Appointment", exception.getMessage());
    }
}
