package org.vitosdeveloper.clinic_management.application.exceptions;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AppointmentSlotTakenExceptionTest {
    @Test
    void testInstanceAndMessage() {
        LocalDateTime appointmentDate = LocalDateTime.now();
        AppointmentSlotTakenException exception = new AppointmentSlotTakenException(appointmentDate);
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Appointment slot for " + appointmentDate + " is already taken.", exception.getMessage());
    }
}
