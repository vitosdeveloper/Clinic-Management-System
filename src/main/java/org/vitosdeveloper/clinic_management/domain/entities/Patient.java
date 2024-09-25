package org.vitosdeveloper.clinic_management.domain.entities;

import org.springframework.util.StringUtils;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidBirthDateException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidCpfException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidCrmException;

import java.time.LocalDate;

public class Patient extends User {
    private final String cpf;
    private final LocalDate birthDate;

    public Patient(Long id, String email, String password, String cpf, LocalDate birthDate) {
        super(id, email, password, Role.PATIENT);
        this.cpf = cpf;
        this.birthDate = birthDate;
        validateFields();
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    private void validateFields() {
        if (cpf == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(cpf))) throw new InvalidCpfException();
        if (!LocalDate.class.isInstance(birthDate)) throw new InvalidBirthDateException();
    }
}
