package org.vitosdeveloper.clinic_management.domain.entities;

import org.vitosdeveloper.clinic_management.domain.enums.Status;

import java.time.LocalDateTime;

public class Appointment {
    private Long id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDate;
    private Status status;
    private String reason;

    public Appointment(Long id, Patient patient, Doctor doctor, LocalDateTime appointmentDate, Status status, String reason) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}
