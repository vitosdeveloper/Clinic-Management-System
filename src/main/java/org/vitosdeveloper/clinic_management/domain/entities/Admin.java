package org.vitosdeveloper.clinic_management.domain.entities;

import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidLastLoginException;

import java.time.LocalDateTime;

public class Admin extends User {
    private LocalDateTime lastLogin;

    public Admin(Long id, String email, String password, LocalDateTime lastLogin) {
        super(id, email, password, Role.ADMIN);
        this.lastLogin = lastLogin;
        validateAdminFields();
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    private void validateAdminFields(){
        if (lastLogin == null) throw new InvalidLastLoginException();
    }
}
