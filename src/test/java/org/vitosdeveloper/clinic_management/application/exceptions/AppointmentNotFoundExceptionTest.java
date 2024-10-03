package org.vitosdeveloper.clinic_management.application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AppointmentNotFoundExceptionTest {
    @Test
    void testInstanceAndMessage() {
        AppointmentNotFoundException exception = new AppointmentNotFoundException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Appointment not found.", exception.getMessage());
    }
}
