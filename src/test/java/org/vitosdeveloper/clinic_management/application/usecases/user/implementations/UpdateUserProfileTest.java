package org.vitosdeveloper.clinic_management.application.usecases.user.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.vitosdeveloper.clinic_management.application.exceptions.EmailAlreadyExistsException;
import org.vitosdeveloper.clinic_management.application.exceptions.UserNotFoundException;
import org.vitosdeveloper.clinic_management.application.security.IPasswordHasher;
import org.vitosdeveloper.clinic_management.domain.entities.User;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.repositories.IUserRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateUserProfileTest {
    @Mock
    private IUserRepository userRepository;
    @Mock
    private IPasswordHasher passwordHasher;
    @InjectMocks
    private UpdateUserProfile updateUserProfile;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldUpdateUserProfileSuccessfully() {
        Long userId = 1L;
        String email = "newEmail@gmail.com";
        String password = "newPassword";
        String hashedPassword = "hashedPassword";
        User existingUser = new User(userId, "oldmail@example.com", "oldPassword", Role.PATIENT);
        User updatedUser = new User(userId, email, hashedPassword, Role.PATIENT);

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        when(passwordHasher.hash(password)).thenReturn(hashedPassword);
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User result = updateUserProfile.execute(userId, email, password);

        assertNotNull(result);
        assertEquals(email, result.getEmail());
        assertEquals(hashedPassword, result.getPassword());
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void shouldThrowUserNotFoundException() {
        Long userId = 1L;
        String email = "newEmail@example.com";
        String password = "newPassword";

        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {
            updateUserProfile.execute(userId, email, password);
        });
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void shouldThrowEmailAlreadyExistsException() {
        Long userId = 1L;
        String email = "newEmail@example.com";
        String password = "newPassword";
        User existingUser = new User(userId, "oldemail@example.com", "oldPassword", Role.PATIENT);
        User anotherUser = new User(2L, email, "somePassword", Role.PATIENT);

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(anotherUser));

        assertThrows(EmailAlreadyExistsException.class, () -> {
            updateUserProfile.execute(userId, email, password);
        });

        verify(userRepository, never()).save(any(User.class));
    }
}
