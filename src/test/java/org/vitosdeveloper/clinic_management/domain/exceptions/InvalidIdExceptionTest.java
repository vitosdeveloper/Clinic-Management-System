package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidIdExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidIdException exception = new InvalidIdException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid id", exception.getMessage());
    }
}
