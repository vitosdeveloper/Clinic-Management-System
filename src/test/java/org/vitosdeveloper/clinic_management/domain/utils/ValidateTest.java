package org.vitosdeveloper.clinic_management.domain.utils;

import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidCpfException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidEmailException;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateTest {
    @Test
    public void correctEmailValidations() {
        assertDoesNotThrow(() -> {
            Validate.emailWithRegex("vitosdeveloper@gmail.com");
            Validate.emailWithRegex("adfsd12342f223f3f@fgssd.com");
        });
    }

    @Test
    public void incorrectEmailValidations() {
        assertThrows(InvalidEmailException.class, () -> Validate.emailWithRegex(""));
        assertThrows(InvalidEmailException.class, () -> Validate.emailWithRegex(null));
        assertThrows(InvalidEmailException.class, () -> Validate.emailWithRegex("@gmail.com"));
        assertThrows(InvalidEmailException.class, () -> Validate.emailWithRegex("vitos.com"));
    }

    @Test
    public void correctCpfValidations() {
        assertDoesNotThrow(() -> Validate.cpfWithRegex("000.000.000-00"));
    }

    @Test
    public void incorrectCpfValidations() {
        assertThrows(InvalidCpfException.class, () -> Validate.cpfWithRegex("000000.000-00"));
        assertThrows(InvalidCpfException.class, () -> Validate.cpfWithRegex("000..000.000-00"));
        assertThrows(InvalidCpfException.class, () -> Validate.cpfWithRegex("00.000.000-00"));
        assertThrows(InvalidCpfException.class, () -> Validate.cpfWithRegex("000.00.000-00"));
        assertThrows(InvalidCpfException.class, () -> Validate.cpfWithRegex("000.000.00-00"));
        assertThrows(InvalidCpfException.class, () -> Validate.cpfWithRegex("000.000.000-0"));
    }
}
