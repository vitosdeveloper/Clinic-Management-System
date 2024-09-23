package org.vitosdeveloper.clinic_management.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Patient extends User {
    private String cpf;
    private LocalDate birthDate;

    public Patient(Long id, String email, String password, LocalDateTime createdAt, String cpf, LocalDate birthDate) {
        super(id, email, password, createdAt);
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
