package org.vitosdeveloper.clinic_management.domain.exceptions;

public class InvalidCpfException extends RuntimeException {
    public InvalidCpfException() {
        super("Invalid Cpf");
    }
}
