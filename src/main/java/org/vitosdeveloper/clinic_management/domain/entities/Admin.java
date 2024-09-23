package org.vitosdeveloper.clinic_management.domain.entities;

import java.time.LocalDateTime;

public class Admin extends User {
    private LocalDateTime lastLogin;

    public Admin(Long id, String email, String password, LocalDateTime createdAt, LocalDateTime lastLogin) {
        super(id, email, password, createdAt);
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
