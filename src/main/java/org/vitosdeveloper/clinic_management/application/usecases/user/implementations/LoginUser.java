package org.vitosdeveloper.clinic_management.application.usecases.user.implementations;

import org.vitosdeveloper.clinic_management.application.security.IPasswordHasher;
import org.vitosdeveloper.clinic_management.application.usecases.user.contracts.ILoginUser;
import org.vitosdeveloper.clinic_management.domain.entities.User;
import org.vitosdeveloper.clinic_management.application.exceptions.InvalidCredentialsException;
import org.vitosdeveloper.clinic_management.domain.repositories.IUserRepository;

public class LoginUser implements ILoginUser {
    private final IUserRepository userRepository;
    private final IPasswordHasher passwordHasher;

    public LoginUser(IUserRepository userRepository, IPasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public User execute(String email, String password) {
        User user = this.userRepository.findByEmail(email).orElseThrow(InvalidCredentialsException::new);
        if (!passwordHasher.verify(password, user.getPassword())) throw new InvalidCredentialsException();
        return user;
    }
}
