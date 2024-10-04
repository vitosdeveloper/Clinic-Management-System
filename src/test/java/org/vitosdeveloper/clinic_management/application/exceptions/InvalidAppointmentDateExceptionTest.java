package org.vitosdeveloper.clinic_management.application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidAppointmentDateExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidAppointmentDateException exception = new InvalidAppointmentDateException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("The appointment date is invalid.", exception.getMessage());
    }
}
