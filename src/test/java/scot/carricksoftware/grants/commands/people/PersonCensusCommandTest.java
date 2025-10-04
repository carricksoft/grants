/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 02:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.people;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.images.Image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


class PersonCensusCommandTest {

    PersonCommand command;

    @BeforeEach
    void setUp() {
        command = new PersonCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }

    @Test
    void getFirstNameTest() {
        assertNull(command.getFirstName());
    }

    @Test
    void setFirstNameTest() {
        String firstName = GetRandomString();
        command.setFirstName(firstName);
    }

    @Test
    void getLastNameTest() {
        assertNull(command.getLastName());
    }

    @Test
    void setLastNameTest() {
        String lastName = GetRandomString();
        command.setLastName(lastName);
    }

    @Test
    void getRecodedYearOfBirthTest() {
        assertNull(command.getRecordedYearOfBirth());
    }

    @Test
    void setRecordedYearOfBirthTest() {
        String string = GetRandomString();
        command.setRecordedYearOfBirth(string);
        assertEquals(string, command.getRecordedYearOfBirth());
    }

    @Test
    void getCertifiedYearOfBirthTest() {
        assertNull(command.getCertifiedYearOfBirth());
    }

    @Test
    void setCertifiedYearOfBirthTest() {
        String string = GetRandomString();
        command.setCertifiedYearOfBirth(string);
        assertEquals(string, command.getCertifiedYearOfBirth());
    }

    @Test
    void setImageTest() {
        Image image = new Image();
        command.setImage(image);
        assertEquals(image, command.getImage());
    }

    @Test
    void getImageTest() {
        assertNull(command.getImage());
    }

}