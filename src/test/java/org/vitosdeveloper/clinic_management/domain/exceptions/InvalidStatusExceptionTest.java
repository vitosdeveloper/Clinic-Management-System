package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidStatusExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidStatusException exception = new InvalidStatusException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Status", exception.getMessage());
    }
}
