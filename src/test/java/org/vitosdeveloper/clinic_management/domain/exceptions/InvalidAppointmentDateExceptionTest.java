package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidAppointmentDateExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidAppointmentDateException exception = new InvalidAppointmentDateException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid AppointmentDate", exception.getMessage());
    }
}
