package org.vitosdeveloper.clinic_management.application.usecases.user.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.vitosdeveloper.clinic_management.application.exceptions.AppointmentSlotTakenException;
import org.vitosdeveloper.clinic_management.application.exceptions.DoctorNotFoundException;
import org.vitosdeveloper.clinic_management.application.exceptions.PatientNotFoundException;
import org.vitosdeveloper.clinic_management.domain.entities.Appointment;
import org.vitosdeveloper.clinic_management.domain.entities.Doctor;
import org.vitosdeveloper.clinic_management.domain.entities.Patient;
import org.vitosdeveloper.clinic_management.domain.enums.Status;
import org.vitosdeveloper.clinic_management.domain.repositories.IAppointmentRepository;
import org.vitosdeveloper.clinic_management.domain.repositories.IDoctorRepository;
import org.vitosdeveloper.clinic_management.domain.repositories.IPatientRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ScheduleAppointmentTest {
    @Mock
    private IAppointmentRepository appointmentRepository;
    @Mock
    private IDoctorRepository doctorRepository;
    @Mock
    private IPatientRepository patientRepository;
    @InjectMocks
    private ScheduleAppointment scheduleAppointment;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateAppointmentSuccessfully() {
        Long doctorId = 1L;
        Long patientId = 2L;
        LocalDateTime appointmentDate = LocalDateTime.now().plusDays(1);
        Doctor doctor = new Doctor(doctorId, "DrSmith@gmail.com", "DoctorPassword", "crm", List.of(), List.of());
        Patient patient = new Patient(patientId, "JohnDoe@gmail.com", "userPassword", "000.000.000-00", LocalDate.now());

        when(this.doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(this.appointmentRepository.isAppointmentSlotTaken(doctorId, appointmentDate)).thenReturn(false);
        when(this.patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

        Appointment appointment = new Appointment(null, patient, doctor, appointmentDate, Status.PENDING, "reason");
        when(this.appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment result = this.scheduleAppointment.execute(doctorId, patientId, appointmentDate, "reason");

        assertNotNull(result);
        assertEquals(doctor, result.getDoctor());
        assertEquals(patient, result.getPatient());
        assertEquals(appointmentDate, result.getAppointmentDate());
        verify(appointmentRepository).save(any(Appointment.class));
    }

    @Test
    public void shouldThrowDoctorNotFoundException() {
        Long doctorId = 1L;
        Long patientId = 2L;
        LocalDateTime appointmentDate = LocalDateTime.now().plusDays(1);

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.empty());

        assertThrows(DoctorNotFoundException.class, () -> {
            scheduleAppointment.execute(doctorId, patientId, appointmentDate, "reason");
        });

        verify(appointmentRepository, never()).save(any(Appointment.class));
    }

    @Test
    public void shouldThrowPatientNotFoundException() {
        Long doctorId = 1L;
        Long patientId = 2L;
        LocalDateTime appointmentDate = LocalDateTime.now().plusDays(1);
        Doctor doctor = new Doctor(doctorId, "DrSmith@gmail.com", "DoctorPassword", "crm", List.of(), List.of());

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        assertThrows(PatientNotFoundException.class, () -> {
            scheduleAppointment.execute(doctorId, patientId, appointmentDate, "reason");
        });

        verify(appointmentRepository, never()).save(any(Appointment.class));
    }

    @Test
    public void shouldThrowAppointmentSlotTakenException() {
        Long doctorId = 1L;
        Long patientId = 2L;
        LocalDateTime appointmentDate = LocalDateTime.now().plusDays(1);
        Doctor doctor = new Doctor(doctorId, "DrSmith@gmail.com", "DoctorPassword", "crm", List.of(), List.of());
        Patient patient = new Patient(patientId, "JohnDoe@gmail.com", "userPassword", "000.000.000-00", LocalDate.now());

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
        when(appointmentRepository.isAppointmentSlotTaken(doctorId, appointmentDate)).thenReturn(true);

        assertThrows(AppointmentSlotTakenException.class, () -> {
            scheduleAppointment.execute(doctorId, patientId, appointmentDate, "reason");
        });

        verify(appointmentRepository, never()).save(any(Appointment.class));
    }
}
