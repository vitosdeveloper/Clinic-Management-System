package org.vitosdeveloper.clinic_management.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class InvalidCpfExceptionTest {
    @Test
    void testInstanceAndMessage() {
        InvalidCpfException exception = new InvalidCpfException();
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Invalid Cpf", exception.getMessage());
    }
}
