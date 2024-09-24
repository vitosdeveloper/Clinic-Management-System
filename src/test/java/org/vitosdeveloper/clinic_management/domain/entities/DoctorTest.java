package org.vitosdeveloper.clinic_management.domain.entities;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidAppointmentException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidCrmException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidSpecialistyException;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {
    Long expectedId = 1L;
    String expectedEmail = "test@example.com";
    String expectedPassword = "securePassword";
    Role expectedRole = Role.DOCTOR;
    String expectedCrm = "crm test";
    List<Speciality> expectedSpecialities = List.of();
    List<Appointment> expectedAppointments = List.of();

    @Test
    void testDoctorConstructorGettersAndInstances() {
        Doctor doctor = new Doctor(expectedId, expectedEmail, expectedPassword, expectedCrm, expectedSpecialities, expectedAppointments);
        assertEquals(expectedId, doctor.getId());
        assertEquals(expectedEmail, doctor.getEmail());
        assertEquals(expectedPassword, doctor.getPassword());
        assertEquals(expectedRole, doctor.getRole());
        assertEquals(expectedCrm, doctor.getCrm());
        assertEquals(expectedSpecialities, doctor.getSpecialities());
        assertEquals(expectedAppointments, doctor.getAppoitments());
        assertInstanceOf(LocalDateTime.class, doctor.getCreatedAt());
        assertInstanceOf(User.class, doctor);
    }

    @Test
    void testDoctorValidations() {
        InvalidCrmException exceptionOne = assertThrows(InvalidCrmException.class, () -> {
            new Doctor(expectedId, expectedEmail, expectedPassword, null, expectedSpecialities, expectedAppointments);
        });
        assertEquals("Invalid Crm", exceptionOne.getMessage());

        InvalidSpecialistyException exceptionTwo = assertThrows(InvalidSpecialistyException.class, () -> {
            new Doctor(expectedId, expectedEmail, expectedPassword, expectedCrm, null, expectedAppointments);
        });
        assertEquals("Invalid Speciality", exceptionTwo.getMessage());

        InvalidAppointmentException exceptionThree = assertThrows(InvalidAppointmentException.class, () -> {
            new Doctor(expectedId, expectedEmail, expectedPassword, expectedCrm, expectedSpecialities, null);
        });
        assertEquals("Invalid Appointment", exceptionThree.getMessage());
    }
}
