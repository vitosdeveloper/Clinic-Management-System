package org.vitosdeveloper.clinic_management.application.usecases.user.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.application.exceptions.InvalidCredentialsException;
import org.vitosdeveloper.clinic_management.application.security.IPasswordHasher;
import org.vitosdeveloper.clinic_management.domain.entities.User;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.repositories.IUserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginUserTest {
    private IUserRepository userRepository;
    private IPasswordHasher passwordHasher;
    private LoginUser loginUser;

    @BeforeEach
    void setUp() {
        userRepository = mock(IUserRepository.class);
        passwordHasher = mock(IPasswordHasher.class);
        loginUser = new LoginUser(userRepository, passwordHasher);
    }

    @Test
    void shouldLoginSuccessfully() {
        String email = "test@example.com";
        String password = "password123";
        User user = new User(1L, email, "hashedPassword", Role.PATIENT);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        when(passwordHasher.verify(password, "hashedPassword")).thenReturn(true);

        User result = loginUser.execute(email, password);

        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void shouldThrowInvalidCredentialsExceptionsWhenUserNotFound() {
        String email = "test@example.com";
        String password = "password123";

        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        assertThrows(InvalidCredentialsException.class, () -> loginUser.execute(email, password));
    }

    @Test
    void shouldThrowInvalidCredentialsExceptionWhenPasswordDoesNotMatch() {
        String email = "test@example.com";
        String password = "password123";
        User user = new User(1L, email, "hashedPassword", Role.PATIENT);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        when(passwordHasher.verify(password, "hashedPassword")).thenReturn(false);

        assertThrows(InvalidCredentialsException.class, () -> loginUser.execute(email, password));
    }
}
