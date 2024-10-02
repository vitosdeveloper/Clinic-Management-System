package org.vitosdeveloper.clinic_management.application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class PatientNotFoundExceptionTest {
    @Test
    void testInstanceAndMessage() {
        Long patientId = 1L;
        PatientNotFoundException exception = new PatientNotFoundException(patientId);
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Patient with ID " + patientId + " not found.", exception.getMessage());
    }
}
