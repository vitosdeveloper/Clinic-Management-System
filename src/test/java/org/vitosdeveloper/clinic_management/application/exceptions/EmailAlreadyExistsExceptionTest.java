package org.vitosdeveloper.clinic_management.application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class EmailAlreadyExistsExceptionTest {
    @Test
    void testInstanceAndMessage() {
        String email = "teste@teste.com";
        EmailAlreadyExistsException exception = new EmailAlreadyExistsException(email);
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Email " + email + " is already in use.", exception.getMessage());
    }
}
