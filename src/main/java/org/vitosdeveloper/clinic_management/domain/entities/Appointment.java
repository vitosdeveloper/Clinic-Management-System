package org.vitosdeveloper.clinic_management.domain.entities;

import org.springframework.util.StringUtils;
import org.vitosdeveloper.clinic_management.domain.enums.Status;
import org.vitosdeveloper.clinic_management.domain.exceptions.*;

import java.time.LocalDateTime;

public class Appointment {
    private final Long id;
    private final Patient patient;
    private final Doctor doctor;
    private LocalDateTime appointmentDate;
    private Status status;
    private final String reason;

    public Appointment(Long id, Patient patient, Doctor doctor, LocalDateTime appointmentDate, Status status, String reason) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.reason = reason;
        validateFields();
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

    public void setStatus(Status newStatus) {
        this.status = newStatus;
    }

    public void setAppointmentDate(LocalDateTime newDate) {
        this.appointmentDate = newDate;
    }

    private void validateFields() {
        if (id != null && id <= 0L) throw new InvalidIdException();
        if (patient == null) throw new InvalidPatientException();
        if (doctor == null) throw new InvalidDoctorException();
        if (appointmentDate == null) throw new InvalidAppointmentDateException();
        if (status == null) throw new InvalidStatusException();
        if (reason == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(reason))
                || reason.length() < 3) throw new InvalidReasonException();
    }
}
