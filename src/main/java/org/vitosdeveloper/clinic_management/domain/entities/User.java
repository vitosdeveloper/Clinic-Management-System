package org.vitosdeveloper.clinic_management.domain.entities;

import org.springframework.util.StringUtils;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidEmailException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidIdException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidPasswordException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidRoleException;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class User {
    private final Long id;
    private final String email;
    private final String password;
    private final LocalDateTime createdAt;
    private final Role role;
    private static final String EMAIL_PATTERN = "^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,4}$";

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

    public void validateFields() {
        if (this.id == null || id <= 0L) throw new InvalidIdException();
        if (this.email == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(this.email)) ||
                !Pattern.matches(EMAIL_PATTERN, email))
            throw new InvalidEmailException();
        if (this.password == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(this.password))
                || this.password.length() < 6)
            throw new InvalidPasswordException();
        if (role == null) throw new InvalidRoleException();
    }
}
