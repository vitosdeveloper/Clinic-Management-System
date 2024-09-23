package org.vitosdeveloper.clinic_management.domain.entities;

import org.vitosdeveloper.clinic_management.domain.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Patient extends User {
    private final String cpf;
    private final LocalDate birthDate;

    public Patient(Long id, String email, String password, String cpf, LocalDate birthDate) {
        super(id, email, password, Role.PATIENT);
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
