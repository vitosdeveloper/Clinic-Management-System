package org.vitosdeveloper.clinic_management.domain.entities;

import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidBirthDateException;
import org.vitosdeveloper.clinic_management.domain.utils.Validate;

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
        Validate.cpfWithRegex(cpf);
        if (!LocalDate.class.isInstance(birthDate)) throw new InvalidBirthDateException();
    }
}
