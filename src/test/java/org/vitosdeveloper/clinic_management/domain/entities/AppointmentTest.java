package org.vitosdeveloper.clinic_management.domain.entities;

import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.domain.enums.Status;
import org.vitosdeveloper.clinic_management.domain.exceptions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    private Long expectedId = 1L;
    private Patient expectedPatient = new Patient(1L, "johny@gmail.com", "patientPassword", "045.231.231.2", LocalDate.now());
    private Doctor expectedDoctor = new Doctor(1L, "chaluba@gmail.com", "doctorPassword", "crm", List.of(), List.of());
    private LocalDateTime expectedAppointmentDate = LocalDateTime.now();
    private Status expectedStatus = Status.PENDING;
    private String expectedReason = "Reason";

    @Test
    void testAppointmentConstructorAndGetters() {
        Appointment appointment = new Appointment(expectedId, expectedPatient, expectedDoctor, expectedAppointmentDate, expectedStatus, expectedReason);
        assertEquals(expectedId, appointment.getId());
        assertEquals(expectedPatient, appointment.getPatient());
        assertEquals(expectedDoctor, appointment.getDoctor());
        assertEquals(expectedAppointmentDate, appointment.getAppointmentDate());
        assertEquals(expectedStatus, appointment.getStatus());
        assertEquals(expectedReason, appointment.getReason());
        assertInstanceOf(LocalDateTime.class, appointment.getAppointmentDate());
    }

    @Test
    void testIdValidation() {
        InvalidIdException exceptionTwo = assertThrows(InvalidIdException.class, () -> {
            new Appointment(-1L, expectedPatient, expectedDoctor, expectedAppointmentDate, expectedStatus, expectedReason);
        });
        assertEquals("Invalid id", exceptionTwo.getMessage());

        InvalidIdException exceptionThree = assertThrows(InvalidIdException.class, () -> {
            new Appointment(null, expectedPatient, expectedDoctor, expectedAppointmentDate, expectedStatus, expectedReason);
        });
        assertEquals("Invalid id", exceptionThree.getMessage());
    }

    @Test
    void testPatientValidation() {
        InvalidPatientException exceptionThree = assertThrows(InvalidPatientException.class, () -> {
            new Appointment(expectedId, null, expectedDoctor, expectedAppointmentDate, expectedStatus, expectedReason);
        });
        assertEquals("Invalid Patient", exceptionThree.getMessage());
    }

    @Test
    void testDoctorValidation() {
        InvalidDoctorException exceptionThree = assertThrows(InvalidDoctorException.class, () -> {
            new Appointment(expectedId, expectedPatient, null, expectedAppointmentDate, expectedStatus, expectedReason);
        });
        assertEquals("Invalid Doctor", exceptionThree.getMessage());
    }

    @Test
    void testAppointmentDateValidation() {
        InvalidAppointmentDateException exceptionThree = assertThrows(InvalidAppointmentDateException.class, () -> {
            new Appointment(expectedId, expectedPatient, expectedDoctor, null, expectedStatus, expectedReason);
        });
        assertEquals("Invalid AppointmentDate", exceptionThree.getMessage());
    }

    @Test
    void testStatusValidation() {
        InvalidStatusException exceptionThree = assertThrows(InvalidStatusException.class, () -> {
            new Appointment(expectedId, expectedPatient, expectedDoctor, expectedAppointmentDate, null, expectedReason);
        });
        assertEquals("Invalid Status", exceptionThree.getMessage());
    }

    @Test
    void testReasonValidation() {
        InvalidReasonException exceptionThree = assertThrows(InvalidReasonException.class, () -> {
            new Appointment(expectedId, expectedPatient, expectedDoctor, expectedAppointmentDate, expectedStatus, null);
        });
        assertEquals("Invalid reason, it should have at least 3 characters", exceptionThree.getMessage());
    }
}
