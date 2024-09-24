package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidCrmExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidCrmException exception = new InvalidCrmException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Crm", exception.getMessage());
    }
}
