package org.vitosdeveloper.clinic_management.application.usecases.user.implementations;

import org.vitosdeveloper.clinic_management.application.security.IPasswordHasher;
import org.vitosdeveloper.clinic_management.application.usecases.user.contracts.IRegisterUser;
import org.vitosdeveloper.clinic_management.domain.entities.User;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.repositories.IUserRepository;

public class RegisterUser implements IRegisterUser {
    private final IUserRepository userRepository;
    private final IPasswordHasher passwordHasher;

    public RegisterUser(IUserRepository userRepository, IPasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public void execute(String email, String password, Role role) {
        String hashedPassword = passwordHasher.hash(password);
        User user = new User(null, email, hashedPassword, role);
        userRepository.save(user);
    }
}
