package org.vitosdeveloper.clinic_management.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Doctor extends User {
    private String crm;
    private List<Speciality> specialities;
    private List<Appointment> appoitments;

    public Doctor(Long id, String email, String password, LocalDateTime createdAt, String crm,
                  List<Speciality> specialities, List<Appointment> appoitments) {
        super(id, email, password, createdAt);
        this.crm = crm;
        this.specialities = specialities;
        this.appoitments = appoitments;
    }

    public String getCrm() {
        return crm;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public List<Appointment> getAppoitments() {
        return appoitments;
    }
}
