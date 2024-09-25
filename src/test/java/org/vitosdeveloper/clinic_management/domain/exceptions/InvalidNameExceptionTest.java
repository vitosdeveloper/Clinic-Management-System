package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidNameExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidNameException exception = new InvalidNameException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Name", exception.getMessage());
    }
}
