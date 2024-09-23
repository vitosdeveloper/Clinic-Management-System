package org.vitosdeveloper.clinic_management.domain.entities;

import org.vitosdeveloper.clinic_management.domain.enums.Role;

import java.time.LocalDateTime;
import java.util.List;

public class Doctor extends User {
    private final String crm;
    private final List<Speciality> specialities;
    private final List<Appointment> appoitments;

    public Doctor(Long id, String email, String password, String crm,
                  List<Speciality> specialities, List<Appointment> appoitments) {
        super(id, email, password, Role.DOCTOR);
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
