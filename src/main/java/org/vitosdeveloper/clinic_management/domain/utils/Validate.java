package org.vitosdeveloper.clinic_management.domain.utils;

import org.springframework.util.StringUtils;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidCpfException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidEmailException;

import java.util.regex.Pattern;

public class Validate {
    private static final String EMAIL_PATTERN = "^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,4}$";
    private static final String CPF_PATTERN = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    static public void emailWithRegex(String email) throws InvalidEmailException {
        if (email == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(email)) ||
                !Pattern.matches(EMAIL_PATTERN, email))
            throw new InvalidEmailException();
    }

    static public void cpfWithRegex(String cpf) throws InvalidCpfException {
        if (cpf == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(cpf)) ||
                !Pattern.matches(CPF_PATTERN, cpf))
            throw new InvalidCpfException();
    }
}
