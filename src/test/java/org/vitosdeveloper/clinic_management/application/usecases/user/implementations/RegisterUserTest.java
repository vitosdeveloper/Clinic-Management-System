package org.vitosdeveloper.clinic_management.application.usecases.user.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.vitosdeveloper.clinic_management.application.security.IPasswordHasher;
import org.vitosdeveloper.clinic_management.domain.entities.User;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidPasswordException;
import org.vitosdeveloper.clinic_management.domain.repositories.IUserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegisterUserTest {
    private IUserRepository userRepository;
    private IPasswordHasher passwordHasher;
    private RegisterUser registerUser;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(IUserRepository.class);
        passwordHasher = Mockito.mock(IPasswordHasher.class);
        registerUser = new RegisterUser(userRepository, passwordHasher);
    }

    @Test
    void shouldCreateUserAndSaveWithHashedPassword() {
        String email = "test@example.com";
        String rawPassword = "password123";
        String hashedPassword = "hashedPassword123";
        Role role = Role.PATIENT;

        when(passwordHasher.hash(rawPassword)).thenReturn(hashedPassword);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        registerUser.execute(email, rawPassword, role);

        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();

        assertNull(savedUser.getId(), "The ID should be null before saving");
        assertEquals(email, savedUser.getEmail());
        assertEquals(hashedPassword, savedUser.getPassword());
        assertEquals(role, savedUser.getRole());

        verify(passwordHasher, times(1)).hash(rawPassword);
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsInvalid() {
        String email = "test@example.com";
        String invalidPassword = "";
        Role role = Role.PATIENT;

        assertThrows(InvalidPasswordException.class, () -> {
            registerUser.execute(email, invalidPassword, role);
        });

        verify(userRepository, never()).save(any());
    }
}
