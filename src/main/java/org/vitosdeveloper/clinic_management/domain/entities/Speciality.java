package org.vitosdeveloper.clinic_management.domain.entities;

import org.springframework.util.StringUtils;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidIdException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidNameException;


public class Speciality {
    private final Long id;
    private final String name;

    public Speciality(Long id, String name) {
        this.id = id;
        this.name = name;
        validateFields();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void validateFields() {
        if (this.id == null || id <= 0L) throw new InvalidIdException();
        if (this.name == null || !StringUtils.hasLength(StringUtils.trimAllWhitespace(this.name)))
            throw new InvalidNameException();
    }
}
