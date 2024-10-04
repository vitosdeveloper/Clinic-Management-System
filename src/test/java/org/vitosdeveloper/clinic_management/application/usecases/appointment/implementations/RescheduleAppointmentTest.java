package org.vitosdeveloper.clinic_management.application.usecases.appointment.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.vitosdeveloper.clinic_management.application.exceptions.AppointmentNotFoundException;
import org.vitosdeveloper.clinic_management.application.exceptions.InvalidAppointmentDateException;
import org.vitosdeveloper.clinic_management.domain.entities.Appointment;
import org.vitosdeveloper.clinic_management.domain.repositories.IAppointmentRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class RescheduleAppointmentTest {
    @Mock
    IAppointmentRepository appointmentRepository;
    @InjectMocks
    private RescheduleAppointment rescheduleAppointment;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldRescheduleAppointmentIfValid() {
        Appointment appointment = mock(Appointment.class);
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));
        LocalDateTime newDateTime = LocalDateTime.now().plusDays(1);

        rescheduleAppointment.execute(1L, newDateTime);

        verify(appointment).setAppointmentDate(newDateTime);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void shouldThrowAppointmentNotFoundExceptionIfAppointmentDoesNotExist() {
        when(appointmentRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(AppointmentNotFoundException.class, () ->
                rescheduleAppointment.execute(1L, LocalDateTime.now().plusDays(1)));
    }

    @Test
    void shouldThrowInvalidAppointmentDateExceptionIfNewDateIsInThePast() {
        Appointment appointment = mock(Appointment.class);
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));
        assertThrows(InvalidAppointmentDateException.class, () ->
                rescheduleAppointment.execute(1L, LocalDateTime.now().minusDays(1)));
    }
}
