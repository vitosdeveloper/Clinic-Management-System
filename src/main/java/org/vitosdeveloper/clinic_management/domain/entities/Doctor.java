package org.vitosdeveloper.clinic_management.domain.entities;

import org.springframework.util.StringUtils;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidAppointmentException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidCrmException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidSpecialistException;

import java.util.List;

public class Doctor extends User {
    private final String crm;
    private final List<Speciality> specialities;
    private final List<Appointment> appointments;

    public Doctor(Long id, String email, String password, String crm,
                  List<Speciality> specialities, List<Appointment> appoitments) {
        super(id, email, password, Role.DOCTOR);
        this.crm = crm;
        this.specialities = specialities;
        this.appointments = appoitments;
        validateDoctorFields();
    }

    public String getCrm() {
        return crm;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public List<Appointment> getAppoitments() {
        return appointments;
    }

    private void validateDoctorFields() {
        if (crm == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(crm))) throw new InvalidCrmException();
        if (specialities == null) throw new InvalidSpecialistException();
        if (appointments == null) throw new InvalidAppointmentException();
        specialities.forEach(speciality -> {
            if (!Speciality.class.isInstance(speciality)) throw new InvalidSpecialistException();
        });
        appointments.forEach(apopintment -> {
            if (!Appointment.class.isInstance(apopintment)) throw new InvalidAppointmentException();
        });
    }
}
