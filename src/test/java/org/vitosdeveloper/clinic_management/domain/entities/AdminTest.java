package org.vitosdeveloper.clinic_management.domain.entities;

import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    Long expectedId = 1L;
    String expectedEmail = "test@example.com";
    String expectedPassword = "securePassword";
    LocalDateTime expectedLastLogin = LocalDateTime.now();

    @Test
    void testAdminConstructorGettersAndInstances() {
        Admin admin = new Admin(expectedId, expectedEmail, expectedPassword, expectedLastLogin);
        assertEquals(expectedId, admin.getId());
        assertEquals(expectedEmail, admin.getEmail());
        assertEquals(expectedPassword, admin.getPassword());
        assertEquals(expectedLastLogin, admin.getLastLogin());
        assertEquals(Role.ADMIN, admin.getRole());
        assertInstanceOf(LocalDateTime.class, admin.getCreatedAt());
        assertInstanceOf(User.class, admin);
    }

    @Test
    void shouldSetANewLastLogin(){
        Admin admin = new Admin(expectedId, expectedEmail, expectedPassword, expectedLastLogin);
        LocalDateTime newLastLogin = LocalDateTime.now();
        admin.setLastLogin(newLastLogin);
        assertEquals(newLastLogin, admin.getLastLogin());
    }

    @Test
    void testAdminValidations(){
        InvalidLastLoginException exceptionOne = assertThrows(InvalidLastLoginException.class, () ->
                new Admin(expectedId, expectedEmail, expectedPassword, null));
        assertEquals("Invalid lastLogin" ,exceptionOne.getMessage());
    }
}
