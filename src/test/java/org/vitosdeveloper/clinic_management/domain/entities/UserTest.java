package org.vitosdeveloper.clinic_management.domain.entities;

import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidEmailException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidIdException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidPasswordException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidRoleException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    Long expectedId = 1L;
    String expectedEmail = "test@example.com";
    String expectedPassword = "securePassword";
    Role expectedRole = Role.PATIENT;

    @Test
    void testUserConstructorAndGetters() {
        User user = new User(expectedId, expectedEmail, expectedPassword, expectedRole);
        assertEquals(expectedId, user.getId());
        assertEquals(expectedEmail, user.getEmail());
        assertEquals(expectedPassword, user.getPassword());
        assertEquals(expectedRole, user.getRole());
        assertInstanceOf(LocalDateTime.class, user.getCreatedAt());
    }

    @Test
    void testIdValidation() {
        InvalidIdException exceptionOne = assertThrows(InvalidIdException.class, () -> {
            new User(null, expectedEmail, expectedPassword, expectedRole);
        });
        assertEquals("Invalid id", exceptionOne.getMessage());

        InvalidIdException exceptionTwo = assertThrows(InvalidIdException.class, () -> {
            new User(-1L, "badEmailFormat", expectedPassword, expectedRole);
        });
        assertEquals("Invalid id", exceptionTwo.getMessage());
    }

    @Test
    void testEmailValidation() {
        InvalidEmailException exceptionOne = assertThrows(InvalidEmailException.class, () -> {
            new User(expectedId, "", expectedPassword, expectedRole);
        });
        assertEquals("Invalid email", exceptionOne.getMessage());

        InvalidEmailException exceptionTwo = assertThrows(InvalidEmailException.class, () -> {
            new User(expectedId, "badEmailFormat", expectedPassword, expectedRole);
        });
        assertEquals("Invalid email", exceptionTwo.getMessage());

        InvalidEmailException exceptionThree = assertThrows(InvalidEmailException.class, () -> {
            new User(expectedId, null, expectedPassword, expectedRole);
        });
        assertEquals("Invalid email", exceptionThree.getMessage());
    }

    @Test
    void testPasswordValidation() {
        InvalidPasswordException exceptionOne = assertThrows(InvalidPasswordException.class, () -> {
            new User(expectedId, expectedEmail, "", expectedRole);
        });
        assertEquals("Invalid password", exceptionOne.getMessage());

        InvalidPasswordException exceptionTwo = assertThrows(InvalidPasswordException.class, () -> {
            new User(expectedId, expectedEmail, "12345", expectedRole);
        });
        assertEquals("Invalid password", exceptionTwo.getMessage());

        InvalidPasswordException exceptionThree = assertThrows(InvalidPasswordException.class, () -> {
            new User(expectedId, expectedEmail, null, expectedRole);
        });
        assertEquals("Invalid password", exceptionThree.getMessage());
    }

    @Test
    void testRoleValidation() {
        InvalidRoleException exceptionOne = assertThrows(InvalidRoleException.class, () -> {
            new User(expectedId, expectedEmail, expectedPassword, null);
        });
        assertEquals("Invalid role", exceptionOne.getMessage());
    }
}
