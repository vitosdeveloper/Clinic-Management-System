package org.vitosdeveloper.clinic_management.domain.entities;

import org.springframework.util.StringUtils;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidIdException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidPasswordException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidRoleException;
import org.vitosdeveloper.clinic_management.domain.utils.Validate;

import java.time.LocalDateTime;

public class User {
    private final Long id;
    private final String email;
    private final String password;
    private final LocalDateTime createdAt;
    private final Role role;

    public User(Long id, String email, String password, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.role = role;
        validateFields();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private void validateFields() {
        if (this.id == null || id <= 0L) throw new InvalidIdException();
        Validate.emailWithRegex(email);
        if (this.password == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(this.password))
                || this.password.length() < 6)
            throw new InvalidPasswordException();
        if (role == null) throw new InvalidRoleException();
    }
}
