package org.vitosdeveloper.clinic_management.domain.entities;

import org.junit.jupiter.api.Test;
import org.vitosdeveloper.clinic_management.domain.enums.Role;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidIdException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidLastLoginException;
import org.vitosdeveloper.clinic_management.domain.exceptions.InvalidNameException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialityTest {
    private Long expectedId = 1L;
    private String expectedName = "Surgery";

    @Test
    void testAdminConstructorGetters() {
        Speciality admin = new Speciality(expectedId, expectedName);
        assertEquals(expectedId, admin.getId());
        assertEquals(expectedName, admin.getName());
    }

    @Test
    void testAdminValidations() {
        InvalidIdException exceptionOne = assertThrows(InvalidIdException.class, () ->
                new Speciality(-1L, expectedName));
        assertEquals("Invalid id", exceptionOne.getMessage());

        InvalidIdException exceptionTwo = assertThrows(InvalidIdException.class, () ->
                new Speciality(null, expectedName));
        assertEquals("Invalid id", exceptionTwo.getMessage());

        InvalidNameException exceptionThree = assertThrows(InvalidNameException.class, () ->
                new Speciality(expectedId, null));
        assertEquals("Invalid Name", exceptionThree.getMessage());

        InvalidNameException exceptionFour = assertThrows(InvalidNameException.class, () ->
                new Speciality(expectedId, ""));
        assertEquals("Invalid Name", exceptionFour.getMessage());
    }
}
