package org.vitosdeveloper.clinic_management.domain.entities;

public class Speciality {
    private Long id;
    private String name;

    public Speciality(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
