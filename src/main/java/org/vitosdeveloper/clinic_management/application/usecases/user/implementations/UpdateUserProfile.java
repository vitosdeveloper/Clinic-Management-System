package org.vitosdeveloper.clinic_management.application.usecases.user.implementations;

import org.vitosdeveloper.clinic_management.application.exceptions.EmailAlreadyExistsException;
import org.vitosdeveloper.clinic_management.application.exceptions.UserNotFoundException;
import org.vitosdeveloper.clinic_management.application.security.IPasswordHasher;
import org.vitosdeveloper.clinic_management.application.usecases.user.contracts.IUpdateUserProfile;
import org.vitosdeveloper.clinic_management.domain.entities.User;
import org.vitosdeveloper.clinic_management.domain.repositories.IUserRepository;

import java.util.Optional;

public class UpdateUserProfile implements IUpdateUserProfile {
    IUserRepository userRepository;
    IPasswordHasher passwordHasher;

    public UpdateUserProfile(IUserRepository userRepository, IPasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public User execute(Long userId, String newEmail, String newPassword) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Optional<User> userWithEMail = userRepository.findByEmail(newEmail);
        if (userWithEMail.isPresent() && !userWithEMail.get().getId().equals(userId))
            throw new EmailAlreadyExistsException(newEmail);

        String hashedPassword = this.passwordHasher.hash(newPassword);
        User updatedUser = new User(user.getId(), newEmail, hashedPassword, user.getRole());

        return userRepository.save(updatedUser);
    }
}
