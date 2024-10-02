package org.vitosdeveloper.clinic_management.application.usecases.user.implementations;

import org.vitosdeveloper.clinic_management.application.usecases.user.contracts.IScheduleAppointment;
import org.vitosdeveloper.clinic_management.domain.entities.Appointment;
import org.vitosdeveloper.clinic_management.domain.entities.Doctor;
import org.vitosdeveloper.clinic_management.domain.entities.Patient;
import org.vitosdeveloper.clinic_management.domain.enums.Status;
import org.vitosdeveloper.clinic_management.domain.repositories.IAppointmentRepository;
import org.vitosdeveloper.clinic_management.domain.repositories.IDoctorRepository;
import org.vitosdeveloper.clinic_management.domain.repositories.IPatientRepository;

import java.time.LocalDateTime;

public class ScheduleAppointment implements IScheduleAppointment {
    private final IAppointmentRepository appointmentRepository;
    private final IDoctorRepository doctorRepository;
    private final IPatientRepository patientRepository;

    public ScheduleAppointment(IAppointmentRepository appointmentRepository, IDoctorRepository doctorRepository, IPatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Appointment execute(Long doctorId, Long patientId, LocalDateTime appointmentTime) {
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException(""));
        boolean isSlotTaken = this.appointmentRepository.isAppointmentSlotTaken(doctorId, appointmentTime);
        if (isSlotTaken) throw new RuntimeException("");
        Patient patient = this.patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException(""));
        Appointment appointment = new Appointment(null, patient, doctor, appointmentTime, Status.PENDING, "");
        return this.appointmentRepository.save(appointment);
    }
}
