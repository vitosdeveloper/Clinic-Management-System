package org.vitosdeveloper.clinic_management.domain.entities;

import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationTest {
    Long userId = 1L;
    String userEmail = "test@example.com";
    String userPassword = "securePassword";
    Role userRole = Role.PATIENT;
    Long expectedId = 1L;
    User expectedRecipient = new User(userId, userEmail, userPassword, userRole);
    String expectedMessage = "message";
    LocalDateTime expectedSentAt = LocalDateTime.now();

    @Test
    void testNotificationConstructorGettersAndInstances() {
        Notification notification = new Notification(expectedId, expectedRecipient, expectedMessage, expectedSentAt);
        assertEquals(expectedId, notification.getId());
        assertEquals(expectedRecipient, notification.getRecipient());
        assertEquals(expectedMessage, notification.getMessage());
        assertEquals(expectedSentAt, notification.getSentAt());
        assertInstanceOf(LocalDateTime.class, notification.getSentAt());
    }

    @Test
    void testNotificationValidations() {
        InvalidIdException exceptionOne = assertThrows(InvalidIdException.class, () ->
                new Notification(null, expectedRecipient, expectedMessage, expectedSentAt));
        assertEquals("Invalid id", exceptionOne.getMessage());

        InvalidUserException exceptionTwo = assertThrows(InvalidUserException.class, () ->
                new Notification(expectedId, null, expectedMessage, expectedSentAt));
        assertEquals("Invalid User", exceptionTwo.getMessage());

        InvalidMessageException exceptionThree = assertThrows(InvalidMessageException.class, () ->
                new Notification(expectedId, expectedRecipient, null, expectedSentAt));
        assertEquals("Invalid Message", exceptionThree.getMessage());

        InvalidSentAtException exceptionFour = assertThrows(InvalidSentAtException.class, () ->
                new Notification(expectedId, expectedRecipient, expectedMessage, null));
        assertEquals("Invalid SentAt", exceptionFour.getMessage());
    }
}
