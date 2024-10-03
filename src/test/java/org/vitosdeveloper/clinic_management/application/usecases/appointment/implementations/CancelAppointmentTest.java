package org.vitosdeveloper.clinic_management.application.usecases.appointment.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.vitosdeveloper.clinic_management.application.exceptions.AppointmentNotFoundException;
import org.vitosdeveloper.clinic_management.domain.entities.Appointment;
import org.vitosdeveloper.clinic_management.domain.enums.Status;
import org.vitosdeveloper.clinic_management.domain.repositories.IAppointmentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CancelAppointmentTest {
    @Mock
    private IAppointmentRepository appointmentRepository;
    @InjectMocks
    private CancelAppointment cancelAppointment;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCancelAppointmentIfFound() {
        Appointment appointment = mock(Appointment.class);
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));
        this.cancelAppointment.execute(1L);

        verify(appointment).setStatus(Status.CANCELED);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void shouldThrowAppointmentNotFoundExceptionIfAppointmentDoesNotExist() {
        when(appointmentRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(AppointmentNotFoundException.class, () -> {
            this.cancelAppointment.execute(1L);
        });
    }
}
