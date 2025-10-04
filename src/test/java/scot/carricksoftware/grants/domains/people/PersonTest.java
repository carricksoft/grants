/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.images.Image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void getFirstNameTest() {
        assertNull(person.getFirstName());
    }

    @Test
    void setFirstNameTest() {
        String firstName = GetRandomString();
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    void getLastNameTest() {
        assertNull(person.getLastName());
    }

    @Test
    void setLastNameTest() {
        String lastName = GetRandomString();
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName());
    }


    @Test
    void getRecodedYearOfBirthTest() {
        assertNull(person.getRecordedYearOfBirth());
    }

    @Test
    void setRecordedYearOfBirthTest() {
        String string = GetRandomString();
        person.setRecordedYearOfBirth(string);
        assertEquals(string, person.getRecordedYearOfBirth());
    }

    @Test
    void getCertifiedYearOfBirthTest() {
        assertNull(person.getCertifiedYearOfBirth());
    }

    @Test
    void setCertifiedYearOfBirthTest() {
        String string = GetRandomString();
        person.setCertifiedYearOfBirth(string);
        assertEquals(string, person.getCertifiedYearOfBirth());
    }

    @Test
    void getImageTest() {
        assertNull(person.getImage());
    }

    @Test
    void setImageTest() {
        Image image = new Image();
        person.setImage(image);
        assertEquals(image, person.getImage());
    }

}