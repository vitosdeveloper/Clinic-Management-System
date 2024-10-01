package org.vitosdeveloper.clinic_management.application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class UserNotFoundExceptionTest {
    @Test
    void testInstanceAndMessage() {
        Long userId = 2L;
        UserNotFoundException exception = new UserNotFoundException(userId);
        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("User with ID " + userId + " not found.", exception.getMessage());
    }
}
