package org.vitosdeveloper.clinic_management.domain.entities;

import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidBirthDateException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidCpfException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidLastLoginException;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    Long expectedId = 1L;
    String expectedEmail = "test@example.com";
    String expectedPassword = "securePassword";
    String expectedCpf = "000.000.000-00";
    LocalDate expectedBirthDate = LocalDate.now();

    @Test
    void testPatientConstructorGettersAndInstances() {
        Patient patient = new Patient(expectedId, expectedEmail, expectedPassword, expectedCpf, expectedBirthDate);
        assertEquals(expectedId, patient.getId());
        assertEquals(expectedEmail, patient.getEmail());
        assertEquals(expectedPassword, patient.getPassword());
        assertEquals(Role.PATIENT, patient.getRole());
        assertInstanceOf(LocalDateTime.class, patient.getCreatedAt());
        assertInstanceOf(User.class, patient);
    }

    @Test
    void testValidations() {
        InvalidCpfException exceptionOne = assertThrows(InvalidCpfException.class, () ->
                new Patient(expectedId, expectedEmail, expectedPassword, null, expectedBirthDate));
        assertEquals("Invalid Cpf", exceptionOne.getMessage());

        InvalidBirthDateException exceptiontwo = assertThrows(InvalidBirthDateException.class, () ->
                new Patient(expectedId, expectedEmail, expectedPassword, expectedCpf, null));
        assertEquals("Invalid BirthDate", exceptiontwo.getMessage());
    }
}
