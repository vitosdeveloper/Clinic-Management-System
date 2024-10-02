package org.vitosdeveloper.clinic_management.application.exceptions;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class DoctorNotFoundExceptionTest {
    @Test
    void testInstanceAndMessage() {
        Long doctorId = 1L;
        DoctorNotFoundException exception = new DoctorNotFoundException(doctorId);
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Doctor with ID " + doctorId + " not found.", exception.getMessage());
    }
}
